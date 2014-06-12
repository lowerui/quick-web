package com.quick.web.base.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quick.web.base.service.RoleService;
import com.quick.web.dto.AjaxPage;
import com.quick.web.dto.Message;
import com.quick.web.dto.Query;
import com.quick.web.entity.Role;

import com.google.common.base.Strings;
import com.google.common.base.Splitter;


/**
 * 系统管理-角色管理
 * @author gerry.zhang
 * @date 2014-6-6
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/base/role/")
public class RoleController {
	
	@Resource
	private RoleService roleService;//角色service接口
	
	/**
	 * 角色管理list页面
	 * @return
	 */
	@RequestMapping("list")
	public String list(){
		return "base/role/list";
	}
	
	/**
	 * 查询所有角色
	 * @return JSON格式数据
	 */
	@RequestMapping("getAllRole")
	@ResponseBody
	public AjaxPage<Role> getAllRole(Query query){
		AjaxPage<Role> page = roleService.getPage(query);
		return page;
	}
	
	/**
	 * 编辑或者新增角色
	 * @param role
	 * @param model
	 * @return 
	 */
	@RequestMapping("edit")
    public String edit(Role role,Model model){
		if(role.getId() !=null){
			role = roleService.getRoleById(role.getId());
			model.addAttribute("role", role);
		}
    	return "base/role/edit";
    }
	
	/**
	 * 更新或者保存角色
	 * @param role
	 * @return JSON格式提示信息
	 */
	@RequestMapping("save")
	@ResponseBody
	public Message save(Role role){
		if(role.getId()==null){
			roleService.insert(role);
		}else{
			roleService.update(role);
		}
		Message message = new Message(true,"提示信息","保存成功!");
		return message;
	}
	
	/**
	 * 删除角色信息
	 * @description 使用guava的Splitter分割器分割字符串更可靠
	 * @param ids id以","相隔的字符串
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Message delete(String ids){
		if(!Strings.isNullOrEmpty(ids)){
			List<String> list = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(ids);
			roleService.delete(list);
			return new Message(true,"提示信息","删除成功!");
		}
		return new Message(false,"提示信息","删除失败!");
	}
	
	

}
