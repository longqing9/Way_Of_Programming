/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseControllerGson;
import com.thinkgem.jeesite.modules.sys.entity.Menu;
import com.thinkgem.jeesite.modules.sys.entity.VoMenu;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.MenuTreeUtil;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 菜单Controller
 * @author ThinkGem
 * @version 2013-3-23
 */
@Controller
@RequestMapping(value = "${frontPath}/sys/menu")
public class MenuControllerGson extends BaseControllerGson {

	@Autowired
	private SystemService systemService;
	
	
//	@ModelAttribute("menu")
	@ResponseBody
	@RequestMapping(value = "get",method = RequestMethod.GET)
	public String get(@RequestParam(required=false) String id,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Access-Control");
		
		VoMenu voMenu=new VoMenu();
		Menu menu=new Menu();
		if (StringUtils.isNotBlank(id)){
			menu=systemService.getMenu(id);
			UserUtils.setVoMenu(voMenu, menu);
			return JsonMapper.toJsonString(menu);
		}else{
			return JsonMapper.toJsonString(menu);
		}
	}
	
//	@RequiresPermissions("sys:menu:view")
	@CrossOrigin(origins = "*", maxAge = 3600)
	@ResponseBody
	@RequestMapping(value = {"list", ""},method = RequestMethod.GET)
	public Map<String,Object> list(Model model,HttpServletResponse response,HttpServletRequest request) throws JsonProcessingException {
/*		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET");
		response.setHeader("Access-Control-Allow-Headers", "Access-Control");
		response.setHeader("Allow", "GET");
*/		
						
		MenuTreeUtil menuTree = new MenuTreeUtil();
		List<Menu> list = Lists.newArrayList();
		
		List<VoMenu> voMenuList=Lists.newArrayList();
		
		List<Menu> sourcelist = systemService.findAllMenus();
		
		Menu.sortList(list, sourcelist, Menu.getRootId(), true);
		
		for (Menu menu : sourcelist) {
			VoMenu voMenu=new VoMenu();
			UserUtils.setVoMenu(voMenu, menu);
			voMenuList.add(voMenu);
		}
		Gson gson=new Gson();
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "OK");
		map.put("data",gson.toJson(menuTree.getAllTree(voMenuList)));		

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "form")
	public String form(Menu menu, Model model,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Access-Control");
		
		if (menu.getParent()==null||menu.getParent().getId()==null){
			menu.setParent(new Menu(Menu.getRootId()));
		}
		menu.setParent(systemService.getMenu(menu.getParent().getId()));
		// 获取排序号，最末节点排序号+30
		if (StringUtils.isBlank(menu.getId())){
			List<Menu> list = Lists.newArrayList();
			List<Menu> sourcelist = systemService.findAllMenu();
			Menu.sortList(list, sourcelist, menu.getParentId(), false);
			if (list.size() > 0){
				menu.setSort(list.get(list.size()-1).getSort() + 30);
			}
		}
		VoMenu voMenu=new VoMenu();
		UserUtils.setVoMenu(voMenu, menu);
		model.addAttribute("menu", menu);
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value = "save",method = RequestMethod.GET)
	public String save(Menu menu, Model model, RedirectAttributes redirectAttributes,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Access-Control");
		
		if(!UserUtils.getUser().isAdmin()){
			addMessage(redirectAttributes, "越权操作，只有超级管理员才能添加或修改数据！");
			return "redirect:" + adminPath + "/sys/role/?repage";
		}
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/menu/";
		}
		if (!beanValidator(model, menu)){
			return form(menu, model, null);
		}
		systemService.saveMenu(menu);
		addMessage(redirectAttributes, "保存菜单'" + menu.getName() + "'成功");
		return "success";
	}
	
	@RequiresPermissions("sys:menu:edit")
	@ResponseBody
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String delete(Menu menu, RedirectAttributes redirectAttributes,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Access-Control");
		
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/menu/";
		}
//		if (Menu.isRoot(id)){
//			addMessage(redirectAttributes, "删除菜单失败, 不允许删除顶级菜单或编号为空");
//		}else{
			systemService.deleteMenu(menu);
			addMessage(redirectAttributes, "删除菜单成功");
//		}
		return "success";
	}

	@RequiresPermissions("user")
	@RequestMapping(value = "tree")
	public String tree() {
		return "modules/sys/menuTree";
	}

	@RequiresPermissions("user")
	@RequestMapping(value = "treeselect")
	public String treeselect(String parentId, Model model) {
		model.addAttribute("parentId", parentId);
		return "modules/sys/menuTreeselect";
	}
	
	/**
	 * 批量修改菜单排序
	 */
	@RequiresPermissions("sys:menu:edit")
	@RequestMapping(value = "updateSort")
	public String updateSort(String[] ids, Integer[] sorts, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/menu/";
		}
    	for (int i = 0; i < ids.length; i++) {
    		Menu menu = new Menu(ids[i]);
    		menu.setSort(sorts[i]);
    		systemService.updateMenuSort(menu);
    	}
    	addMessage(redirectAttributes, "保存菜单排序成功!");
		return "redirect:" + adminPath + "/sys/menu/";
	}
	
	/**
	 * isShowHide是否显示隐藏菜单
	 * @param extId
	 * @param isShowHidden
	 * @param response
	 * @return
	 */
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId,@RequestParam(required=false) String isShowHide, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Menu> list = systemService.findAllMenu();
		for (int i=0; i<list.size(); i++){
			Menu e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				if(isShowHide != null && isShowHide.equals("0") && e.getIsShow().equals("0")){
					continue;
				}
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
}
