package cn.longQ.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.longQ.common.pojo.EasyUITreeNode;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.content.service.ContentCateGoryService;
import cn.longQ.mapper.TbContentCategoryMapper;
import cn.longQ.pojo.TbContentCategory;
import cn.longQ.pojo.TbContentCategoryExample;
import cn.longQ.pojo.TbContentCategoryExample.Criteria;


@Service
public class ContentCategoryServiceImpl implements ContentCateGoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	
	@Override
	public List<EasyUITreeNode> getContentCateList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> ContentCategorylist = contentCategoryMapper.selectByExample(example);
		List<EasyUITreeNode> list1 = new ArrayList<>();
		for (TbContentCategory list : ContentCategorylist) {
			EasyUITreeNode node =new EasyUITreeNode();
			node.setId(list.getId());
			node.setText(list.getName());
			node.setState(list.getIsParent()?"closed":"open");
			list1.add(node);
		}
		return list1;
	}

	@Override
	public ElfResult addComtentCategory(long parentId, String name) {
		// TODO Auto-generated method stub
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		//1 正常 2 删除
		contentCategory.setStatus(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		contentCategory.setIsParent(false);
		contentCategory.setSortOrder(1);
		contentCategoryMapper.insert(contentCategory);
		//更改父节点的属性值,如果是父节点是叶子结点修改为false
		TbContentCategory selectByPrimaryKey = contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!selectByPrimaryKey.getIsParent()) {
			selectByPrimaryKey.setIsParent(true);
			//更新到数据库中
			contentCategoryMapper.updateByPrimaryKey(selectByPrimaryKey);
		}
		
		return ElfResult.ok(contentCategory);
	}



}
