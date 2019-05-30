package cn.longQ.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.longQ.common.jedis.JedisClient;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.common.utils.JsonUtils;
import cn.longQ.content.service.ContentService;
import cn.longQ.mapper.TbContentMapper;
import cn.longQ.pojo.TbContent;
import cn.longQ.pojo.TbContentExample;
import cn.longQ.pojo.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${CONTENT_LIST}")
	private String CONTENT_LIST;
	
	@Override
	public ElfResult addContent(TbContent content) {
		//向数据库中添加数据
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		//缓存同步
		jedisClient.hdel(CONTENT_LIST, content.getCategoryId()+"");
		return ElfResult.ok();
	}

	@Override
	public List<TbContent> getContentListByCid(long cid) {
		//先进行查询缓存 如果缓存中不存在在进行查询数据库
		try {
			String json = jedisClient.hget(CONTENT_LIST, cid+"");
			if(StringUtils.isNotBlank(json)) {
				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//查询数据库
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		//数据库查询完成 更新缓存添加数据到缓存
		try {
			jedisClient.hset(CONTENT_LIST, cid+"", JsonUtils.objectToJson(list));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
