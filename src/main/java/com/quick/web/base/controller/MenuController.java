package com.quick.web.base.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quick.web.base.service.MenuService;
import com.quick.web.dto.Message;
import com.quick.web.entity.Menu;

/**
 * 系统模块-资源管理
 * @author gerry.zhang
 * @since 2014-5-20
 *
 */
@Controller
@RequestMapping("/base/menu/")
public class MenuController {
	@Resource
	private MenuService menuService;//菜单管理Service接口
	
	
	/**
	 * 初始化菜单
	 */
	@RequestMapping("initMenu")
	@ResponseBody
	public List<Map<String,Object>> initMenu(){
		List<Map<String,Object>> treeList = Lists.newArrayList();
		//一级菜单
		List<Menu> rootMenuList = menuService.getAllMenuByPid(null);
		for(Menu menu:rootMenuList){
			Map<String,Object> map = Maps.newHashMap();
			map.put("menuName", menu.getMenuName());
			map.put("url", menu.getUrl());
			map.put("iconCls", menu.getIconCls());
			//二级菜单
			List<Menu> secondMenuList = menuService.getAllMenuByPid(menu.getId());
			map.put("child", secondMenuList);
			treeList.add(map);
		}
		return treeList;
	}
	
	
	/**
	 * 资源管理
	 * @return
	 */
	@RequestMapping("list")
	public String list(){
		return "base/menu/list";
	}
	
	/**
	 * 资源管理
	 * @return JSON 数据 TreeGrid
	 */
	@RequestMapping("getAllMenu")
	@ResponseBody
	public List<Menu> getAllMenu(Integer id){
		List<Menu> list = menuService.getAllMenuByPid(id);
		return list;
	}
	
	/**
	 * 查询所有菜单 -comboTree
	 * @return JSON数据
	 */
	@RequestMapping("getAllMenuTree")
	@ResponseBody
	public List<Menu> getAllMenuTree(){
		List<Menu> list = menuService.getAllMenu();
		return list;
	}
	
	/**
	 * 添加或者编辑资源
	 * @param id
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(Integer id,Model model){
		if(id !=null){
			Menu menu = menuService.getMenuById(id);
			model.addAttribute("menu", menu);
		}
		return "base/menu/edit";
	}
	
	/**
	 * 保存资源
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	@SuppressWarnings("all")
	public Message save(Menu menu){
		if(menu.getId() ==null){
			menuService.insert(menu);
		}else{
			menuService.update(menu);
		}
		Message message = new Message(true,"提示信息","保存成功!");
		return message;
	}
	
	/**
	 * 删除一个资源
	 * 如果删除上级资源则同时删除该资源下的所有资源
	 * @return Message JSON数据
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Message delete(Integer id){
		menuService.delete(id);
		Message message = new Message(true,"提示信息","删除成功!");
		return message;
	}
	
	
	

}
