package cn.longQ.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.longQ.common.jedis.JedisClient;
import cn.longQ.common.pojo.EasyUIDataGridResult;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.common.utils.IDUtils;
import cn.longQ.common.utils.JsonUtils;
import cn.longQ.mapper.TbItemDescMapper;
import cn.longQ.mapper.TbItemMapper;
import cn.longQ.pojo.TbItem;
import cn.longQ.pojo.TbItemDesc;
import cn.longQ.pojo.TbItemExample;
import cn.longQ.pojo.TbItemExample.Criteria;
import cn.longQ.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;

	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Resource
	private Destination topicDestination;
	@Autowired
	private JedisClient jedisClient;
	@Value("${REDIS_ITEM_PRE}")
	private String REDIS_ITEM_PRE;
	@Value("${TIME_CACHE_EXPIRE}")
	private Integer TIME_CACHE_EXPIRE;

	public TbItem getItemByid(long itemid) {
		//TbItem item = itemMapper.selectByPrimaryKey(itemid);
		//查询缓存
		try {
			String string = jedisClient.get(REDIS_ITEM_PRE+itemid+":BASE");
			if(StringUtils.isNotBlank(string)) {
				TbItem tbItem = JsonUtils.jsonToPojo(string, TbItem.class);
				return tbItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbItemExample Example = new TbItemExample();
		Criteria criteria = Example.createCriteria();
		criteria.andIdEqualTo(itemid);
		List<TbItem> list = itemMapper.selectByExample(Example);
		if(list != null && list.size() > 0) {
			// 添加缓存
			try {
				jedisClient.set(REDIS_ITEM_PRE+itemid+":BASE", JsonUtils.objectToJson(list.get(0)));
				jedisClient.expire(REDIS_ITEM_PRE+itemid+":BASE", TIME_CACHE_EXPIRE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public EasyUIDataGridResult getItem(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//设置查询条件
		TbItemExample itemExample = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(itemExample);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TbItem> info = new PageInfo<>(list);
		long total = info.getTotal();
		result.setTotal(total);
		return result;
	}

	/**
	 * 添加商品，将获取的商品数据分别如添加到两张数据表中分别进行插入
	 */
	@Override
	public ElfResult addItem(TbItem item, String desc) {
		final long id = IDUtils.genItemId();
		item.setId(id);
		//1-正常，2-下架，3-删除'
		item.setStatus((byte) 1);
		Date date = new Date();
		item.setUpdated(date);
		item.setCreated(date);
		itemMapper.insert(item);
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(id);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		itemDescMapper.insert(itemDesc);
		//发送商品添加消息
		jmsTemplate.send(topicDestination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage(id+"");
				return message;
			}
		});
		return ElfResult.ok();
	}

	//根据id删除商品信息
	@Override
	public ElfResult updateItemStatus(List<Long> ids,String method) {
		TbItem item = new TbItem();
		if("delete".equals(method)) {
			item.setStatus((byte)3);
			System.out.println("--------------------------------------");
		}else if("instock".equals(method)) {
			item.setStatus((byte)2);
		}else if("reshelf".equals(method)) {
			item.setStatus((byte)1);
		}
		System.out.println(item.getStatus());
		for (long id : ids) {
			TbItemExample example = new TbItemExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			int j = itemMapper.updateByExampleSelective(item, example);
			
			
		}
		return ElfResult.ok();
	}

	/**
	 *,更新商品信信息,先获取商品的基本信息
	 *
	 *,失败
	 */
	@Override
	public Map<String, Object> updateItemToEdit(long itemid) {
		return null;
	}

	@Override
	public TbItemDesc getItemDescByid(long itemid) {
		//查询缓存
		try {
			String string = jedisClient.get(REDIS_ITEM_PRE+itemid+":DESC");
			if(StringUtils.isNotBlank(string)) {
				TbItemDesc itemDesc = JsonUtils.jsonToPojo(string, TbItemDesc.class);
				return itemDesc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TbItemDesc desc = itemDescMapper.selectByPrimaryKey(itemid);
		
		// 添加缓存
		try {
			jedisClient.set(REDIS_ITEM_PRE+itemid+":DESC", JsonUtils.objectToJson(desc));
			jedisClient.expire(REDIS_ITEM_PRE+itemid+":DESC", TIME_CACHE_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return desc;
	}
}
