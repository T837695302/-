package com.student.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.bean.Student;
import com.student.dao.StudentDao;
import com.student.dao.TeacherDao;

@Controller
public class StudentController {
	/**
	 *
	 * 从数据库中获取全部学生信息，将数据返回给主页index,jsp
	 * @param model
	 * @return 返回值类型： String
	 */
	@RequestMapping(value = "/all")
	public String queryAll(Model model) {

		ApplicationContext contextStu = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从ioc容器中获取dao
		StudentDao dao = (StudentDao) contextStu.getBean("dao");
		model.addAttribute("students", dao.queryAll());

		ApplicationContext contextTea = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从ioc容器中获取dao
		TeacherDao daoTea = (TeacherDao) contextTea.getBean("daoTea");
		model.addAttribute("teachers", daoTea.queryAll());
		return "index";
	}

	/**
	 * 通过姓名查找学生，使用模糊查找，将结果返回给index.jsp
	 *
	 * @param name
	 * @param model
	 * @return 返回值类型： String
	 */
	@RequestMapping(value = "/queryByName")
	public String queryByName(String name, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从ioc容器中获取dao
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryByName(name));
		return "index";
	}

	/**
	 * 要弹出的页面消息
	 * @param msg
	 * @return 返回值类型： String
	 */
	public String msg(String msg) {
		return "<script>alert('" + msg + "')</script>";
	}
}
