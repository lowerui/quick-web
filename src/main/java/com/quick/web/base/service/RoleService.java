package com.quick.web.base.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.quick.web.dto.AjaxPage;
import com.quick.web.dto.Query;
import com.quick.web.entity.Role;
import com.quick.web.respository.mybatis.RoleDao;

/**
 * 角色管理Service接口
 * @author gerry.zhang
 * @date 2014-6-6
 * @version 1.0
 *
 */
@Component
public class RoleService {
	
	@Resource
	private RoleDao roleDao;//dao接口
	
	/**
	 * 插入一个角色
	 * @param role
	 * @return id
	 */
	public Integer insert(Role role){
		return roleDao.insert(role);
	}
	
	/**
	 * 编辑一个角色
	 * @param role
	 */
	public void update(Role role){
		roleDao.update(role);
	}
	
	/**
	 * 根据id删除一个角色
	 * @param id
	 */
	public void delete(Integer id){
		roleDao.delete(id);
	}
	
	/**
	 * 批量删除角色
	 * @param list
	 */
	public void delete(List<String> list){
		roleDao.deleteAll(list);
	}
	
	/**
	 * 根据id查询一个角色
	 * @param id
	 * @return
	 */
	public Role getRoleById(Integer id){
		return roleDao.getRoleById(id);
	}
	
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> getAllRole(){
		return roleDao.getAllRole();
	}
	
	/**
	 * 分页查询角色
	 * @param page
	 * @return
	 */
	public AjaxPage<Role> getPage(Query query){
		List<Role> list = roleDao.getPage(query);
		Integer total = roleDao.getTotals(query);
		AjaxPage<Role> page = new AjaxPage<Role>();
		page.setRows(list);
		page.setTotal(total);
		return page;
	}

}
