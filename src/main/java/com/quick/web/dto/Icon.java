package com.quick.web.dto;

import java.io.Serializable;

/**
 * @description icon小图标
 * @author gerry.zhang
 * @date 2014-5-30
 *
 */
public class Icon implements Serializable{
	private static final long serialVersionUID = 1676610195900567470L;
	
	private String iconName;
	private String className;
	
	
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	

}
