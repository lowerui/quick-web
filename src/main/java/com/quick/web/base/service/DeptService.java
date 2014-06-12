package com.quick.web.base.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.quick.web.entity.Dept;
import com.quick.web.respository.mybatis.DeptDao;
import com.quick.web.util.Constants;
/**
 * 组织机构管理Service接口
 * @author gerry.zhang
 * @since 2014-6-6
 *
 */
@Component
public class DeptService {
	
	@Resource
	private DeptDao deptDao;

	
	/**
	 * 插入一个机构
	 * @param dept
	 * @return id
	 */
	public Integer insert(Dept dept){
		return deptDao.insert(dept);
	}
	
	/**
	 * 编辑一个机构
	 * @param dept
	 */
	public void update(Dept dept){
		deptDao.update(dept);
	}
	
	/**
	 * 根据id删除一个机构
	 * @param id
	 */
	public void delete(Integer id){
		deptDao.delete(id);
	}
	
	/**
	 * 根据id删除一组机构包含所有下级机构
	 * @param id
	 */
	public void deleteAll(Integer id){
		deptDao.deleteAll(id);
	}
	
	/**
	 * 根据id查询一个机构
	 * @param id
	 * @return
	 */
	public Dept getDeptById(Integer id){
		return deptDao.getDeptById(id);
	}
	
	/**
	 * 根据pid查询下级机构
	 * @param pid
	 * @return
	 */
	public List<Dept> getAllDeptByPid(Integer pid){
		List<Dept> list = deptDao.getAllDeptByPid(pid);
		for(Dept dept:list){
			Integer isHasChild = deptDao.isHasChildById(dept.getId());
			if(isHasChild==0){
				dept.setState(Constants.TREE_STATE_OPEN);
			}else{
				dept.setState(Constants.TREE_STATE_CLOSED);
			}
			dept.setIconCls("icon-047");
		}
		return list;
	}
	
	/**
	 * 查询所有组织机构Tree
	 * @return
	 */
	public List<Dept> getAllDept(){
		List<Dept> list = deptDao.getAllDept();
		for(Dept dept:list){
			Integer isHasChild = deptDao.isHasChildById(dept.getId());
			if(isHasChild==0){
				dept.setState(Constants.TREE_STATE_OPEN);
			}else{
				dept.setState(Constants.TREE_STATE_CLOSED);
			}
			dept.setIconCls("icon-047");
		}
		return list;
	}

}
