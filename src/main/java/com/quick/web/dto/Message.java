package com.quick.web.dto;

import java.io.Serializable;

/**
 * 提示信息DTO
 * @author gerry.zhang
 * @date 2014-5-27
 * @version 1.0
 *
 */
public class Message implements Serializable{
	private static final long serialVersionUID = 2607165794883831440L;
	
	private boolean status;
	private String title;
	private String message;
	
	
	public Message(boolean status,String title,String message){
		this.status = status;
		this.title = title;
		this.message = message;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
