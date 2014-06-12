package com.quick.web.base.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.quick.web.entity.Menu;
import com.quick.web.respository.mybatis.MenuDao;
import com.quick.web.util.Constants;

/**
 * 菜单管理Service接口
 * @author gerry.zhang
 * @since 2014-5-22
 *
 */
@Component
public class MenuService {
	
	@Resource
	private MenuDao menuDao;
	
	
	/**
	 * 查询所有菜单 参数id 
	 * 如果为null查询顶级菜单否则查询id下级菜单
	 * @return
	 */
	public List<Menu> getAllMenuByPid(Integer id){
		List<Menu> list = menuDao.getAllMenuByPid(id);
		for(Menu menu:list){
			Integer isHasChild = menuDao.isHasChildById(menu.getId());
			if(isHasChild==0){
				menu.setState(Constants.TREE_STATE_OPEN);
			}else{
				menu.setState(Constants.TREE_STATE_CLOSED);
			}
		}
		return list;
	}
	
	/**
	 * 查询所有菜单
	 * @return
	 */
	public List<Menu> getAllMenu(){
		List<Menu> list =  menuDao.getAllMenu();
		for(Menu menu:list){
			Integer isHasChild = menuDao.isHasChildById(menu.getId());
			if(isHasChild==0){
				menu.setState(Constants.TREE_STATE_OPEN);
			}else{
				menu.setState(Constants.TREE_STATE_CLOSED);
			}
		}
		return list;
	}
	
	/**
	 * 根据id查询资源
	 * @param id
	 * @return
	 */
	public Menu getMenuById(Integer id){
		return menuDao.getMenuById(id);
	}
	
	/**
	 * 插入操作
	 * @param menu
	 */
	public void insert(Menu menu){
		menuDao.insert(menu);
	}
	
	/**
	 * 更新操作
	 * @param menu
	 */
	public void update(Menu menu){
		menuDao.update(menu);
	}
	
	/**
	 * 根据id 删除资源包含下级资源
	 * @param id 资源Id
	 */
	public void delete(Integer id){
		menuDao.delete(id);
	}
	
	
	

}
