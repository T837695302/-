package com.aaa.controller;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaa.bean.Aaa;
import com.aaa.dao.AaaDao;


@Controller
/**
 * グラフのすべての情報を捜す
 * @author User
 *
 */
public class AaaController {
	@RequestMapping(value = "/allaaa")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AaaDao dao = (AaaDao) context.getBean("aaadao");

		List<Aaa> aaaList = dao.queryAll();
		model.addAttribute("aaaList", aaaList);

		return "aaa";
	}


	// @RequestMapping(value = "/displayteaList")
	// public String queryAlltea(Model model) {
	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("applicationContext.xml");
	// TeacherDao dao = (TeacherDao) context.getBean("teadao");
	// List<Teacher> teacherList = new ArrayList<Teacher>();
	// teacherList = dao.queryAll();
	// model.addAttribute("teachers", teacherList);
	// return "teacher";
	// }
	/**
	 *
	 * @param name
	 * @param model
	 * @return
	 */
	/**
	 * 名前に沿ってグラフを捜す
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "queryBysname")
	public String queryBysName(String name, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AaaDao dao = (AaaDao) context.getBean("aaadao");
		model.addAttribute("aaaList", dao.queryAll());
		return "aaa";
	}
@RequestMapping(value = "/delebyid")
public String delebyid(String id,Model model) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	AaaDao dao = (AaaDao) context.getBean("aaadao");
	boolean result = dao.deleteAaa(Integer.parseInt(id));
	if (result) {
		System.out.println("削除成功");
	} else {
		System.out.println("削除失敗");
	}
	model.addAttribute("aaaList", dao.queryAll());
	return "aaa";
}


	@RequestMapping(value = "/updates")
	public String Updateaaa(String id, String name, String place, String weight, String line,String address, Model model) {
		ApplicationContext context = new
				 ClassPathXmlApplicationContext("applicationContext.xml");
				 AaaDao dao = (AaaDao) context.getBean("aaadao");
				 Aaa aaa = new Aaa();
		aaa.setId(Integer.parseInt(id));
		aaa.setName(name);
		aaa.setPlace(place);
		aaa.setWeight(Integer.parseInt(weight));
		aaa.setLine(Integer.parseInt(line));
		aaa.setAddress(address);
		boolean result = dao.updaAaa(aaa);
		if (result) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
		model.addAttribute("aaaList", dao.queryAll());
		return "aaa";
	}
	@RequestMapping(value = "/addaaa")
	public String AddAaa(String name, String place,  String weight, String line,String address, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AaaDao dao = (AaaDao) context.getBean("aaadao");
		Aaa aaa = new Aaa();
		aaa.setName(name);
		aaa.setPlace(place);
		aaa.setWeight(Integer.parseInt(weight));
		aaa.setLine(Integer.parseInt(line));
		aaa.setAddress(address);
		boolean result = dao.addAaa(aaa);
		if (result) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
		model.addAttribute("aaaList", dao.queryAll());
		return "aaa";
	}


	/**
	 * 郵便番号から住所を添加する
	 * @param address
	 * @param model
	 * @return
	 */


}
