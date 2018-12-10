package com.pro.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.bean.Pro;
import com.pro.dao.ProDao;

@Controller
public class ProController {
	@RequestMapping(value = "/pro")
	public String quaryAll(Model model) {
		ApplicationContext classPath = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao proDao = (ProDao) classPath.getBean("proDao");
		List<Pro> proList = proDao.queryAll();
		model.addAttribute("pros", proList);
		return "pro";
	}
}
