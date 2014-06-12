package com.quick.web.base.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.quick.web.dto.Icon;
import com.quick.web.util.Constants;

/**
 * @description 系统模块-样式管理
 * @author gerry.zhang
 * @date 2014-5-30
 * @version 1.0
 *
 */
@RequestMapping("/base/style/")
@Controller
public class StyleController {
	
	/**
	 * @description 浏览ICON小图标
	 * @return
	 */
	@RequestMapping("viewIcon")
	public String viewIcon(Model model,HttpServletRequest request){
		String contextPath = request.getSession().getServletContext().getRealPath("/");
		File dir = new File(contextPath+Constants.ICON_PATH);
		List<Icon> list = Lists.newArrayList();
		for(String file:dir.list()){
			Icon icon = new Icon();
			icon.setIconName(file);
			icon.setClassName("icon-"+file.substring(0, file.indexOf(".")));
			
			list.add(icon);
		}
		model.addAttribute("list", list);
		return "base/style/viewIcon";
	}

}
