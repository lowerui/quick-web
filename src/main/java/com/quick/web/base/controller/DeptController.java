package com.quick.web.base.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.quick.web.base.service.DeptService;
import com.quick.web.dto.Message;
import com.quick.web.entity.Dept;

/**
 * 系统模块-组织机构管理
 * @author gerry.zhang
 * @date 2014-6-6
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/base/dept/")
public class DeptController {
	
	@Resource
	private DeptService deptService;//组织机构service接口
	
	/**
	 * 组织机构管理
	 * @return
	 */
	@RequestMapping("list")
	public String list(){
		return "base/dept/list";
	}
	
	
	/**
	 * 组织机构treeGrid数据
	 * @param id
	 * @return
	 */
	@RequestMapping("getAllDept")
	@ResponseBody
	public List<Dept> getAllDept(Integer id){
		List<Dept> list = deptService.getAllDeptByPid(id);
		return list;
	}
	
	/**
	 * 添加或者编辑组织机构
	 * @param dept
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(Dept dept,Model model){
		if(dept.getId() !=null){
			dept = deptService.getDeptById(dept.getId());
			model.addAttribute("dept", dept);
		}
		return "base/dept/edit"; 
	}
	
	/**
	 * 保存组织机构
	 * @return Message 是封装好的消息提示类
	 */
	@RequestMapping("save")
	@ResponseBody
	@SuppressWarnings("all")
	public Message save(Dept dept){
		if(dept.getId() ==null){
			deptService.insert(dept);
		}
		//更新path 树路径
		if(dept.getPid() ==null){
			dept.setPath(","+dept.getId()+",");
		}else{
			Dept parent = deptService.getDeptById(dept.getPid());
			dept.setPath(parent.getPath()+dept.getId()+",");
		}
		deptService.update(dept);
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
		deptService.deleteAll(id);
		Message message = new Message(true,"提示信息","删除成功!");
		return message;
	}
	
	/**
	 * 查询所有组织机构 -comboTree
	 * @return JSON数据
	 */
	@RequestMapping("getAllDeptTree")
	@ResponseBody
	public List<Dept> getAllDeptTree(){
		List<Dept> list = deptService.getAllDept();
		return list;
	}
	
	
	

}
