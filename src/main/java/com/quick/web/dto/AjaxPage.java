package com.quick.web.dto;

import java.util.List;

/**
 * easyui ajax分页工具类
 * @author gerry.zhang
 * @version 1.0
 * @date 2014-6-9
 * @total 总记录数
 * @rows 记录
 *
 */
public class AjaxPage<T> {
	private int total;
	private List<T> rows;

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	

}
