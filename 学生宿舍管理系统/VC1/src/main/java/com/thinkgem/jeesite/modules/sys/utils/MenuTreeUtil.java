package com.thinkgem.jeesite.modules.sys.utils;

import java.util.ArrayList;
import java.util.List;

import com.thinkgem.jeesite.modules.sys.entity.VoMenu;

public class MenuTreeUtil{
	public List<VoMenu> getAllTree(List<VoMenu> allTreeList) {
		List<VoMenu> parentTreeList = new ArrayList<VoMenu>();
//		List<VoMenu> allTreeList = tOrgDao.findAllNode();//查询所有集合
		
		// 查询的所有节点集合为空
		if (allTreeList == null || allTreeList.size() == 0) {
			return null;
		}
		
		
		// 先找到所有的一级菜单
		for (int i = 0; i < allTreeList.size(); i++) {
			String a=allTreeList.get(i).getParent().getId();
			// 找出没有parentId的节点
			if ("0".equals(allTreeList.get(i).getParent().getId())) {
				parentTreeList.add(allTreeList.get(i));
			}
//			if (allTreeList.get(i).getParent().getId() == "0") {
//				parentTreeList.add(allTreeList.get(i));
//			}
		}
		// 为一级菜单设置子菜单
		for (VoMenu treeDmnObj : parentTreeList) {
			treeDmnObj.setVoMenu(getChild(treeDmnObj, treeDmnObj.getId(), allTreeList));
		}
		return parentTreeList;

	}


public List<VoMenu> getChild(VoMenu treeDmnObj, String orgId, List<VoMenu> allTreeList) {
		// 子菜单
		List<VoMenu> childTreeList = new ArrayList<VoMenu>();

		for (VoMenu dmnObj : allTreeList) {
			// 遍历所有菜单，将父菜单与传过来的id比较
			if (dmnObj.getParent().getId() != "0") {
				String a=dmnObj.getParent().getId();
				if (dmnObj.getParent().getId().equals(orgId)) {
					childTreeList.add(dmnObj);
				}
			}
		}

		// 将子菜单的子菜单再遍历
		for (VoMenu treeDmnObj1 : childTreeList) {
			if (treeDmnObj1.getHref() == null) {
				treeDmnObj1.setVoMenu(getChild(treeDmnObj1, treeDmnObj1.getId(), allTreeList));
			}
		}
		// 退出
		if (childTreeList.size() == 0) {
			return null;
		}
		return childTreeList;
	}
}