package com.quick.web.entity;

/**
 * 实体类 菜单功能
 * @author gerry.zhang
 * @since 2014-5-20
 * menuName 资源名称
 * url 资源路径
 * type 资源类型 0 菜单 1 动作
 * sequence 序号
 * pid 上级资源
 * path 资源层级路径
 * iconCls 资源图标
 * description 描述
 * state 取值closed 有下级节点 open 无下级节点
 */
public class Menu extends BaseEntity{
	private static final long serialVersionUID = -7337846961043266651L;
	
	private String menuName;
	private String url;
	private Integer type;
	private Integer sort;
	private Integer pid;
	private String path;
	private String iconCls;
	private String description;
	private String state;

	
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
