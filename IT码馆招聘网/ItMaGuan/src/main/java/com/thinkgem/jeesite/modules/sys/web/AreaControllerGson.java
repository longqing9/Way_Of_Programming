package com.thinkgem.jeesite.modules.sys.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseControllerGson;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.entity.VoArea;
import com.thinkgem.jeesite.modules.sys.service.AreaService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller
@RequestMapping(value = "${frontPath}/sys/area")
public class AreaControllerGson  extends BaseControllerGson {
	@Autowired
	private AreaService areaService;
	
	@ResponseBody
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String get(@RequestParam(required=false) String id,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Access-Control");
		
		VoArea voarea=new VoArea();
		Area area=new Area();
		if (StringUtils.isNotBlank(id)){
			area=areaService.get(id);
			UserUtils.setVoArea(voarea, area);
			return JsonMapper.toJsonString(voarea);
		}else{
			return JsonMapper.toJsonString(voarea);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""},method = RequestMethod.GET)
	public String list(HttpServletResponse response,HttpServletRequest request){
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=utf-8");
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Headers", "Access-Control");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET");
		response.setHeader("Access-Control-Allow-Headers", "Access-Control");
		response.setHeader("Allow", "GET");

//		PrintWriter pw = response.getWriter();
		
		List<VoArea> listVoArea=new ArrayList<VoArea>();
		List<Area> areaList=areaService.findAll();
		for (Area area : areaList) {
			VoArea voarea=new VoArea();
			UserUtils.setVoArea(voarea, area);
			listVoArea.add(voarea);
		}
//		pw.print(JsonMapper.toJsonString(listVoArea));
//		pw.close();
		return JsonMapper.toJsonString(listVoArea);
	}

	@ResponseBody
	@RequestMapping(value = "form",method = RequestMethod.GET)
	public String form(Area area, Model model,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Access-Control");
		
		if (area.getParent()==null||area.getParent().getId()==null){
			area.setParent(UserUtils.getUser().getOffice().getArea());
		}
		area.setParent(areaService.get(area.getParent().getId()));
		VoArea voarea=new VoArea();
		UserUtils.setVoArea(voarea, area);
		return JsonMapper.toJsonString(voarea);
	}
	@ResponseBody
	@RequestMapping(value = "save",method = RequestMethod.GET)
	public String save(Area area, Model model, RedirectAttributes redirectAttributes,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Access-Control");
		
		areaService.save(area);
		VoArea voarea=new VoArea();
		UserUtils.setVoArea(voarea, area);
		return JsonMapper.toJsonString(voarea);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String delete(Area area, RedirectAttributes redirectAttributes,HttpServletResponse response) {
		VoArea voarea=new VoArea();
		UserUtils.setVoArea(voarea, area);
		if(Global.isDemoMode()){
			return JsonMapper.toJsonString(voarea);
		}
			areaService.delete(area);
		return JsonMapper.toJsonString(voarea);
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Area> list = areaService.findAll();
		for (int i=0; i<list.size(); i++){
			Area e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
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
