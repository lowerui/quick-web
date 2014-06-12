package com.quick.web.base.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.quick.web.dto.AjaxPage;
import com.quick.web.dto.Query;
import com.quick.web.entity.User;
import com.quick.web.respository.mybatis.UserDao;

/**
 * 用户管理Service接口
 * @author gerry.zhang
 * @date 2014-6-12
 * @version 1.0
 *
 */
@Component
public class UserService {
	
	@Resource
	private UserDao userDao;//dao接口
	
	/**
	 * 插入一个用户
	 * @param user
	 * @return id
	 */
	public Integer insert(User user){
		return userDao.insert(user);
	}
	
	/**
	 * 编辑一个用户
	 * @param user
	 */
	public void update(User user){
		userDao.update(user);
	}
	
	/**
	 * 根据id删除一个用户
	 * @param id
	 */
	public void delete(Integer id){
		userDao.delete(id);
	}
	
	/**
	 * 批量删除用户
	 * @param list
	 */
	public void delete(List<String> list){
		userDao.deleteAll(list);
	}
	
	/**
	 * 根据id查询一个用户
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id){
		return userDao.getUserById(id);
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> getAllUser(){
		return userDao.getAllUser();
	}
	
	/**
	 * 分页查询用户
	 * @param page
	 * @return
	 */
	public AjaxPage<User> getPage(Query query){
		List<User> list = userDao.getPage(query);
		Integer total = userDao.getTotals(query);
		AjaxPage<User> page = new AjaxPage<User>();
		page.setRows(list);
		page.setTotal(total);
		return page;
	}

}
