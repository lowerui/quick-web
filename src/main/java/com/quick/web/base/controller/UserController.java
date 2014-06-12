package com.quick.web.base.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quick.web.base.service.UserService;
import com.quick.web.dto.AjaxPage;
import com.quick.web.dto.Message;
import com.quick.web.dto.Query;
import com.quick.web.entity.User;

import com.google.common.base.Strings;
import com.google.common.base.Splitter;


/**
 * 系统管理-用户管理
 * @author gerry.zhang
 * @date 2014-6-12
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/base/user/")
public class UserController {
	
	@Resource
	private UserService userService;//用户service接口
	
	/**
	 * 用户管理list页面
	 * @return
	 */
	@RequestMapping("list")
	public String list(){
		return "base/user/list";
	}
	
	/**
	 * 查询所有用户
	 * @return JSON格式数据
	 */
	@RequestMapping("getAllUser")
	@ResponseBody
	public AjaxPage<User> getAllUser(Query query){
		AjaxPage<User> page = userService.getPage(query);
		return page;
	}
	
	/**
	 * 编辑或者新增用户
	 * @param user
	 * @param model
	 * @return 
	 */
	@RequestMapping("edit")
    public String edit(User user,Model model){
		if(user.getId() !=null){
			user = userService.getUserById(user.getId());
			model.addAttribute("user", user);
		}
    	return "base/user/edit";
    }
	
	/**
	 * 更新或者保存用户
	 * @param user
	 * @return JSON格式提示信息
	 */
	@RequestMapping("save")
	@ResponseBody
	public Message save(User user){
		if(user.getId()==null){
			userService.insert(user);
		}else{
			userService.update(user);
		}
		Message message = new Message(true,"提示信息","保存成功!");
		return message;
	}
	
	/**
	 * 删除用户信息
	 * @description 使用guava的Splitter分割器分割字符串更可靠
	 * @param ids id以","相隔的字符串
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Message delete(String ids){
		if(!Strings.isNullOrEmpty(ids)){
			List<String> list = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(ids);
			userService.delete(list);
			return new Message(true,"提示信息","删除成功!");
		}
		return new Message(false,"提示信息","删除失败!");
	}
	
	

}
