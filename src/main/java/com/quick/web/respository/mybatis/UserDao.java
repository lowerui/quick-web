package com.quick.web.respository.mybatis;

import java.util.List;
import com.quick.web.dto.Query;
import com.quick.web.entity.User;

/**
 * 用户Dao接口
 * @author gerry.zhang
 * @since 2014-6-12
 * @version 1.0
 */
@MybatisRepository
public interface UserDao {
	
	/**
	 * 插入一个用户
	 * @param role
	 * @return id
	 */
	public Integer insert(User user);
	
	/**
	 * 编辑一个用户
	 * @param role
	 */
	public void update(User user);
	
	/**
	 * 根据id删除一个用户
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 批量删除用户
	 * @param list
	 */
	public void deleteAll(List<String> list);
	
	/**
	 * 根据id查询一个用户
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> getAllUser();
	
	/**
	 * 分页查询用户
	 * @param page
	 * @return
	 */
	public List<User> getPage(Query query);
	
	/**
	 * 查询总记录数
	 * @param query
	 * @return
	 */
	public Integer getTotals(Query query);
	

}
