package com.quick.web.respository.mybatis;

import java.util.List;

import com.quick.web.entity.Dept;

/**
 * 组织机构Dao接口
 * @author gerry.zhang
 * @since 2014-6-6
 * @version 1.0
 */
@MybatisRepository
public interface DeptDao {
	
	/**
	 * 插入一个机构
	 * @param dept
	 * @return id
	 */
	public Integer insert(Dept dept);
	
	/**
	 * 编辑一个机构
	 * @param dept
	 */
	public void update(Dept dept);
	
	/**
	 * 根据id删除一个机构
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 根据id删除一组机构包含所有下级机构
	 * @param id
	 */
	public void deleteAll(Integer id);
	
	/**
	 * 根据id查询一个机构
	 * @param id
	 * @return
	 */
	public Dept getDeptById(Integer id);
	
	/**
	 * 根据pid查询下级机构
	 * @param pid
	 * @return
	 */
	public List<Dept> getAllDeptByPid(Integer pid);
	
	/**
	 * 是否有孩子节点
	 * @return 0 没有；大于0有
	 */
	public Integer isHasChildById(Integer id);
	
	/**
	 * 查询所有组织机构
	 * @return
	 */
	public List<Dept> getAllDept();
	

}
