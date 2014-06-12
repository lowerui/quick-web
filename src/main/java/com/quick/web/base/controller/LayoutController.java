package com.quick.web.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Easyui 布局管理器
 * @author gerry.zhang
 * @since 2014-5-21
 *
 */
@Controller
@RequestMapping("/base/layout/")
public class LayoutController {
	
	/**
	 * 头部
	 * @return
	 */
	@RequestMapping("north")
	public String north(){
		return "layout/north";
	}
	
	/**
	 * 底部
	 * @return
	 */
	@RequestMapping("south")
	public String south(){
		return "layout/south";
	}
	
	/**
	 * 主体
	 * @return
	 */
	@RequestMapping("center")
	public String center(){
		return "layout/center";
	}
	

}
