package com.quick.web.respository.mybatis;

import java.util.List;
import com.quick.web.dto.Query;
import com.quick.web.entity.Role;

/**
 * 角色Dao接口
 * @author gerry.zhang
 * @since 2014-6-6
 * @version 1.0
 */
@MybatisRepository
public interface RoleDao {
	
	/**
	 * 插入一个角色
	 * @param role
	 * @return id
	 */
	public Integer insert(Role role);
	
	/**
	 * 编辑一个角色
	 * @param role
	 */
	public void update(Role role);
	
	/**
	 * 根据id删除一个角色
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 批量删除角色
	 * @param list
	 */
	public void deleteAll(List<String> list);
	
	/**
	 * 根据id查询一个角色
	 * @param id
	 * @return
	 */
	public Role getRoleById(Integer id);
	
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> getAllRole();
	
	/**
	 * 分页查询角色
	 * @param page
	 * @return
	 */
	public List<Role> getPage(Query query);
	
	/**
	 * 查询总记录数
	 * @param query
	 * @return
	 */
	public Integer getTotals(Query query);
	

}
