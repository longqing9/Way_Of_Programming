/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.utils;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.sys.dao.AreaDao;
import com.thinkgem.jeesite.modules.sys.dao.MenuDao;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.sys.dao.RoleDao;
import com.thinkgem.jeesite.modules.sys.dao.UserDao;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.entity.Menu;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.entity.VoArea;
import com.thinkgem.jeesite.modules.sys.entity.VoMenu;
import com.thinkgem.jeesite.modules.sys.entity.VoOffice;
import com.thinkgem.jeesite.modules.sys.entity.VoRole;
import com.thinkgem.jeesite.modules.sys.entity.VoUser;
import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 用户工具类
 * @author ThinkGem
 * @version 2013-12-05
 */
public class UserUtils {

	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	private static RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);
	private static MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);
	private static AreaDao areaDao = SpringContextHolder.getBean(AreaDao.class);
	private static OfficeDao officeDao = SpringContextHolder.getBean(OfficeDao.class);

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static User get(String id){
		User user = (User)CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
		if (user ==  null){
			user = userDao.get(id);
			if (user == null){
				return null;
			}
			user.setRoleList(roleDao.findList(new Role(user)));
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
		}
		return user;
	}
	
	/**
	 * 获取用户名
	 * @param id
	 * @return
	 */
	public static String getUserName(String id){
		User user = get(id);
		return user.getName();
	}
	
	
	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static User getByLoginName(String loginName){
		User user = (User)CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
		if (user == null){
			user = userDao.getByLoginName(new User(null, loginName));
			if (user == null){
				return null;
			}
			user.setRoleList(roleDao.findList(new Role(user)));
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
		}
		return user;
	}
	
	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache(){
		removeCache(CACHE_ROLE_LIST);
		removeCache(CACHE_MENU_LIST);
		removeCache(CACHE_AREA_LIST);
		removeCache(CACHE_OFFICE_LIST);
		removeCache(CACHE_OFFICE_ALL_LIST);
		UserUtils.clearCache(getUser());
	}
	
	/**
	 * 清除指定用户缓存
	 * @param user
	 */
	public static void clearCache(User user){
		CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getOldLoginName());
		if (user.getOffice() != null && user.getOffice().getId() != null){
			CacheUtils.remove(USER_CACHE, USER_CACHE_LIST_BY_OFFICE_ID_ + user.getOffice().getId());
		}
	}
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static User getUser(){
		Principal principal = getPrincipal();
		if (principal!=null){
			User user = get(principal.getId());
			if (user != null){
				return user;
			}
			return new User();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}
	
	/**
	 * 当前用户是否是管理员
	 * @return
	 */
	public static boolean isAdmin(){
		return getUser().isAdmin();
	}
	
	public static List<User> getAllUserList() {
		return userDao.findAllList();
	}

	/**
	 * 获取当前用户角色列表
	 * @return
	 */
	public static List<Role> getRoleList(){
		@SuppressWarnings("unchecked")
		List<Role> roleList = (List<Role>)getCache(CACHE_ROLE_LIST);
		//roleList==null
		if (roleList == null || roleList.size()==0){
			User user = getUser();
			if (user.isAdmin()){
				roleList = roleDao.findAllList(new Role());
			}else{
				Role role = new Role();
				role.getSqlMap().put("dsf", BaseService.dataScopeFilter(user.getCurrentUser(), "o", "u"));
				roleList = roleDao.findList(role);
			}
			putCache(CACHE_ROLE_LIST, roleList);
		}
		return roleList;
	}
	
	/**
	 * 获取当前用户授权菜单
	 * @return
	 */
	public static List<Menu> getMenuList(){
		@SuppressWarnings("unchecked")
		List<Menu> menuList = (List<Menu>)getCache(CACHE_MENU_LIST);
		if (menuList == null){
			User user = getUser();
			if (user.isAdmin()){
				menuList = menuDao.findAllList(new Menu());
			}else{
				Menu m = new Menu();
				m.setUserId(user.getId());
				menuList = menuDao.findByUserId(m);
			}
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}
	
	/**
	 * 获取当前用户授权的区域
	 * @return
	 */
	public static List<Area> getAreaList(){
		@SuppressWarnings("unchecked")
		List<Area> areaList = (List<Area>)getCache(CACHE_AREA_LIST);
		if (areaList == null){
			areaList = areaDao.findAllList(new Area());
			putCache(CACHE_AREA_LIST, areaList);
		}
		return areaList;
	}
	
	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	public static List<Office> getOfficeList(){
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_LIST);
		if (officeList == null){
			User user = getUser();
			if (user.isAdmin()){
				officeList = officeDao.findAllList(new Office());
			}else{
				Office office = new Office();
				office.getSqlMap().put("dsf", BaseService.dataScopeFilter(user, "a", ""));
				officeList = officeDao.findList(office);
			}
			putCache(CACHE_OFFICE_LIST, officeList);
		}
		return officeList;
	}

	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	public static List<Office> getOfficeAllList(){
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_ALL_LIST);
		if (officeList == null){
			officeList = officeDao.findAllList(new Office());
		}
		return officeList;
	}
	
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
//			subject.logout();
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
//			subject.logout();
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	// ============== User Cache ==============
	
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
//		Object obj = getCacheMap().get(key);
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
//		getCacheMap().put(key, value);
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
//		getCacheMap().remove(key);
		getSession().removeAttribute(key);
	}

	public static void setVoArea(VoArea voarea, Area area) {
		voarea.setId(area.getId());
		voarea.setCode(area.getCode());
		voarea.setCreateBy(area.getCreateBy());
		voarea.setCreateDate(area.getCreateDate());
	}

	public static void setVoMenu(VoMenu voMenu, Menu menu) {
		voMenu.setId(menu.getId());
		voMenu.setCreateBy(menu.getCreateBy());
		voMenu.setCreateDate(menu.getCreateDate());
		voMenu.setCurrentUser(menu.getCurrentUser());
		voMenu.setDelFlag(menu.getDelFlag());
		voMenu.setHref(menu.getHref());
		voMenu.setIcon(menu.getIcon());
		voMenu.setIsNewRecord(menu.getIsNewRecord());
		voMenu.setIsShow(menu.getIsShow());
		voMenu.setName(menu.getName());
		voMenu.setParent(menu.getParent());
		voMenu.setParentIds(menu.getParentIds());
		voMenu.setPermission(menu.getPermission());
		voMenu.setRemarks(menu.getRemarks());
		voMenu.setSort(menu.getSort());
		voMenu.setSqlMap(menu.getSqlMap());
		voMenu.setTarget(menu.getTarget());
		voMenu.setUpdateBy(menu.getUpdateBy());
		voMenu.setUpdateDate(menu.getUpdateDate());
		voMenu.setUserId(menu.getUserId());
		
	}

	public static void setVoOffice(VoOffice voOffice, Office office) {
		voOffice.setAddress(office.getAddress());
		voOffice.setArea(office.getArea());
		voOffice.setChildDeptList(office.getChildDeptList());
		voOffice.setCode(office.getCode());
		voOffice.setCreateBy(office.getCreateBy());
		voOffice.setCreateDate(office.getCreateDate());
		voOffice.setCurrentUser(office.getCurrentUser());
		voOffice.setDelFlag(office.getDelFlag());
		voOffice.setDeputyPerson(office.getDeputyPerson());
		voOffice.setEmail(office.getEmail());
		voOffice.setFax(office.getFax());
		voOffice.setGrade(office.getGrade());
		voOffice.setId(office.getId());
		voOffice.setIsNewRecord(office.getIsNewRecord());
		voOffice.setMaster(office.getMaster());
		voOffice.setName(office.getName());
		
		
		String json = JsonMapper.toJsonString(office.getParent());
		VoOffice jb = (VoOffice) JsonMapper.fromJsonString(json, VoOffice.class);
		/*JSONObject obj = new JSONObject().fromObject(office.getParent());//将json字符串转换为json对象  
        VoOffice jb = (VoOffice)JSONObject.toBean(obj,VoOffice.class);//将建json对象转换为Person对象  
*/        
        
		voOffice.setParent(jb);
		voOffice.setParentIds(office.getParentIds());
		voOffice.setPhone(office.getPhone());
		voOffice.setPrimaryPerson(office.getPrimaryPerson());
		voOffice.setRemarks(voOffice.getRemarks());
		voOffice.setSort(office.getSort());
		voOffice.setSqlMap(office.getSqlMap());
		voOffice.setType(office.getType());
		voOffice.setUpdateBy(office.getUpdateBy());
		voOffice.setUpdateDate(office.getUpdateDate());
		voOffice.setUseable(office.getUseable());
		voOffice.setZipCode(office.getZipCode());
	}

	public static void setVoUser(VoUser voUser, User user) {
		voUser.setCompany(user.getCompany());
		voUser.setCreateBy(user.getCreateBy());
		voUser.setCreateDate(user.getCreateDate());
		voUser.setCurrentUser(user.getCurrentUser());
		voUser.setDelFlag(user.getDelFlag());
		voUser.setEmail(user.getEmail());
		voUser.setId(user.getId());
		voUser.setIsNewRecord(user.getIsNewRecord());
		voUser.setLoginDate(user.getLoginDate());
		voUser.setLoginFlag(user.getLoginFlag());
		voUser.setLoginIp(user.getLoginIp());
		voUser.setLoginName(user.getLoginName());
		voUser.setMobile(user.getMobile());
		voUser.setName(user.getName());
		voUser.setNewPassword(user.getNewPassword());
		voUser.setNo(user.getNo());
		voUser.setOffice(user.getOffice());
		voUser.setOldLoginDate(user.getOldLoginDate());
		voUser.setOldLoginIp(user.getOldLoginIp());
		voUser.setOldLoginName(user.getOldLoginName());
		voUser.setPassword(user.getPassword());
		voUser.setPhone(user.getPhone());
		voUser.setPhoto(user.getPhoto());
		voUser.setRemarks(user.getRemarks());
		voUser.setRole(user.getRole());
		voUser.setRoleIdList(user.getRoleIdList());
		voUser.setRoleList(user.getRoleList());
		voUser.setSqlMap(user.getSqlMap());
		voUser.setUserType(user.getUserType());
		voUser.setUpdateBy(user.getUpdateBy());
		voUser.setUpdateDate(user.getUpdateDate());
	}
	
	public static void setVoRole(VoRole voRole,Role role){
		voRole.setCreateBy(role.getCreateBy());
		voRole.setCreateDate(role.getCreateDate());
		voRole.setCurrentUser(role.getCurrentUser());
		voRole.setDataScope(role.getDataScope());
		voRole.setDelFlag(role.getDelFlag());
		voRole.setEnname(role.getEnname());
		voRole.setId(role.getId());
		voRole.setIsNewRecord(role.getIsNewRecord());
		voRole.setMenuIdList(role.getMenuIdList());
		voRole.setMenuIds(role.getMenuIds());
		voRole.setMenuList(role.getMenuList());
		voRole.setName(role.getName());
		voRole.setOffice(role.getOffice());
		voRole.setOfficeIdList(role.getOfficeIdList());
		voRole.setOfficeIds(role.getOfficeIds());
		voRole.setOfficeList(role.getOfficeList());
		voRole.setOldEnname(role.getOldEnname());
		voRole.setOldName(role.getOldName());
		voRole.setRemarks(role.getRemarks());
		voRole.setRoleType(role.getRoleType());
		voRole.setSqlMap(role.getSqlMap());
		voRole.setSysData(role.getSysData());
		voRole.setUpdateBy(role.getUpdateBy());
		voRole.setUpdateDate(role.getUpdateDate());
		voRole.setUseable(role.getUseable());
		voRole.setUser(role.getUser());
	}

	public static List<Menu> getMenuLists() {
		@SuppressWarnings("unchecked")
		List<Menu> menuList = (List<Menu>)getCache(CACHE_MENU_LIST);
		if (menuList == null){
			User user = getUser();
				menuList = menuDao.findAllList(new Menu());
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}
	
//	public static Map<String, Object> getCacheMap(){
//		Principal principal = getPrincipal();
//		if(principal!=null){
//			return principal.getCacheMap();
//		}
//		return new HashMap<String, Object>();
//	}
	
	
	

}