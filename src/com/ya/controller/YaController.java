package com.ya.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ya.bean.Ya;
import com.ya.dao.YaDao;

@Controller

public class YaController {
	@RequestMapping(value = "/pall")
	public String queryPageALL(String sPage, String ePage, Model model) {
		if (sPage == null) {
			sPage = "0";
		}
		if (ePage == null) {
			ePage = "5";
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		YaDao dao = new YaDao();
		dao = (YaDao) context.getBean("yadao");
		List<Ya> yaList = new ArrayList<Ya>();
		yaList = dao.queryAll();
		int count = yaList.size();
		int start = Integer.valueOf(sPage) * Integer.valueOf(ePage);
		double pageCount = Math.ceil(Integer.valueOf(count) / Integer.valueOf(ePage));
		yaList = dao.queryPageALL(start, Integer.parseInt(ePage));
		model.addAttribute("yaList", yaList);
		model.addAttribute("PageCounts", pageCount);
		return "ya";
	}

	@RequestMapping(value = "/queryByyaname")
	public String querybyyaname(String name, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		YaDao dao = (YaDao) context.getBean("yadao");
		model.addAttribute("yaList", dao.querybyyaname(name));
		return "ya";

	}

	@RequestMapping(value = "/queryByyaid")
	public String querybyyaid(int id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		YaDao dao = (YaDao) context.getBean("yadao");
		model.addAttribute("yaList", dao.querybyyaid(id));
		return "ya";
	}

	@RequestMapping(value = "/deleteya")
	public String deleteyaid(String id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		YaDao dao = (YaDao) context.getBean("yadao");
		boolean result = dao.deleteya(Integer.parseInt(id));
		if (result) {
			System.out.println("削除成功");
		} else {
			System.out.println("削除失敗");
		}
		model.addAttribute("yaList", dao.queryAll());
		return "ya";
	}

	@RequestMapping(value = "/addYa")
	public String yaadd(String name, String hobby, int height, int weight, Model model) {
		ApplicationContext Context = new ClassPathXmlApplicationContext("applicationContext.xml");
		YaDao dao = (YaDao) Context.getBean("yadao");
		Ya ya = new Ya();
		ya.setName(name);
		ya.setHobby(hobby);
		ya.setHeight(height);
		ya.setWeight(weight);
		boolean result = dao.addYa(ya);
		if (result) {
			System.out.println("OK");
		} else {
			System.out.println("NO");
		}
		model.addAttribute("yaList", dao.queryAll());
		return "ya";
	}

}
