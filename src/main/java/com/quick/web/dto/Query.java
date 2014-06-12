package com.quick.web.dto;

import java.io.Serializable;

/**
 * 查询器-封装了通用查询参数
 * 适用于easyui 异步分页
 * @author gerry.zhang
 * @date 2014-6-12
 * @version 1.0
 * @rows 每页显示多少条
 * @page 第几页
 * @start 开始记录数
 * @sort 排序字段
 * @order 排序方式 asc 升序 desc降序
 * @key 单条件查询字段
 * @value 单条件查询值
 */
public class Query implements Serializable{
	private static final long serialVersionUID = 647863290383206866L;
	
	private int rows;
	private int page;
	private int start;
	private String sort;
	private String order;
	private String key;
	private String value;
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStart() {
		this.start = (page-1)*rows;
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
