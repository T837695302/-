package com.teacher.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teacher.bean.Teacher;
import com.teacher.dao.TeacherDao;

@Controller

public class TeacherController {
	@RequestMapping(value = "/tea")
	public String quaryAll(Model model) {
		ApplicationContext classPath = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao teacherDao = (TeacherDao) classPath.getBean("teadao");
		List<Teacher> teacherList = teacherDao.queryAll();

		model.addAttribute("teachers", teacherList);

		return "teacherindex";
	}
}

