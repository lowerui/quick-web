package com.quick.web.entity;

/**
 * 角色实体类
 * @author gerry.zhang
 * @since 2014-5-20
 * name 角色名称
 * sort 排序编号
 * description 描述
 */
public class Role extends BaseEntity{
	private static final long serialVersionUID = -543329086954385651L;
	
	private String name;
	private String description;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
