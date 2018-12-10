package com.student.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.bean.Student;
import com.student.dao.StudentDao;

/**
 * 学生コントロールクラス
 *
 * @author xingw
 *
 */
@Controller
public class StudentController {

	@RequestMapping(value = "/all")
	public String quaryAll(Model model) {
		ApplicationContext classPath = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao = (StudentDao) classPath.getBean("dao");
		List<Student> studentList = studentDao.queryAll();
		model.addAttribute("studentList", studentList);
		return "index";
	}
	
}
