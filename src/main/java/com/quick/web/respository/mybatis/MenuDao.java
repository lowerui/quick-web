package com.quick.web.respository.mybatis;

import java.util.List;
import com.quick.web.entity.Menu;

/**
 * 资源管理Dao接口
 * @author gerry.zhang
 * @since 2014-5-20
 *
 */
@MybatisRepository
public interface MenuDao {
	
	/**
	 * 插入
	 * @param menu
	 * @return
	 */
	public Integer insert(Menu menu);
	
	/**
	 * 更新
	 * @param menu
	 */
	public void update(Menu menu);
	
	/**
	 * 查询所有菜单 参数pid 
	 * 如果为null查询顶级菜单否则查询pid下级菜单
	 * @return
	 */
	public List<Menu> getAllMenuByPid(Integer pid);
	
	/**
	 * 查询所有菜单
	 * @return
	 */
	public List<Menu> getAllMenu();
	
	/**
	 * 判断一个菜单是否有下级 
	 * @param id
	 * @return
	 */
	public Integer isHasChildById(Integer id);
	
	/**
	 * 根据id查询资源
	 * @param id
	 * @return
	 */
	public Menu getMenuById(Integer id);
	
	/**
	 * 根据id 删除资源包含下级资源
	 * @param id
	 */
	public void delete(Integer id);
	

}
