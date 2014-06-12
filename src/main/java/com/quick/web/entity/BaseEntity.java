package com.quick.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类
 * @author Administrator
 * id 主键
 * createDate 创建时间
 * modifyDate 修改时间
 * creatorId 创建者
 * modifyId 修改者
 */
public class BaseEntity implements Serializable{
	private static final long serialVersionUID = -6038275032414009691L;
	
	public Integer id;
	public Date createDate;
	public Integer creatorId;
	public Date modifyDate;
	public Integer modifyId;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	public Integer getModifyId() {
		return modifyId;
	}
	public void setModifyId(Integer modifyId) {
		this.modifyId = modifyId;
	}
	

}
