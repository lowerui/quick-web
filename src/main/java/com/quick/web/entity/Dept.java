package com.quick.web.entity;
/**
 * 组织机构实体类
 * @author gerry.zhang
 * @date 2014-6-6
 * @version 1.0
 * @name 名称
 * @pid 上级机构
 * @sort 排序
 * @email 邮箱
 * @mobile 联系电话
 * @path 树路径
 * @fax 传真
 * @leader 负责人
 * @description 描述
 * @state 取值closed 有下级节点 open 无下级节点
 * @iconCls 更改树控件默认图标
 */
public class Dept extends BaseEntity{
	private static final long serialVersionUID = 779277358417294750L;
	
	private String  name;
	private Integer pid;
	private Integer sort;
	private String email;
	private String mobile;
	private String path;
	private String fax;
	private String description;
	private String leader;
	private String state;
	private String iconCls;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	

}
