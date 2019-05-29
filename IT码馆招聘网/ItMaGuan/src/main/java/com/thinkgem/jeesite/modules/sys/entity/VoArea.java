package com.thinkgem.jeesite.modules.sys.entity;

import com.thinkgem.jeesite.common.persistence.TreeEntity;


public class VoArea extends TreeEntity<VoArea>{
	private static final long serialVersionUID = 1L;
	//	private Area parent;	// 父级编号
//	private String parentIds; // 所有父级编号
	private String code; 	// 区域编码
//	private String name; 	// 区域名称
//	private Integer sort;		// 排序
	private String type; 	// 区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）
	private VoArea parentId;
	
	public VoArea(String id) {
		super(id);
	}
	public VoArea() {
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public VoArea getParent() {
		return parent;
	}
	@Override
	public void setParent(VoArea parent) {
		this.parent=parent;
		
	}
	
	public void setParentId(VoArea parentId) {
		this.parentId = parentId;
	}
	
	
	
	
	
	
}
