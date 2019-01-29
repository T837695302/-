//package com.teacher.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.student.bean.Student;
//import com.student.dao.StudentDao;
//import com.teacher.bean.Teacher;
//import com.teacher.dao.TeacherDao;
//
//@Controller
//
//public class TeacherController {
//	@RequestMapping(value = "/tea")
//	public String queryAll(Model model) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		TeacherDao dao = (TeacherDao) context.getBean("teadao");
//		List<Teacher> teacherList = new ArrayList<Teacher>();
//		teacherList = dao.queryAll();
//		model.addAttribute("teachers", teacherList);
//
//		return "teacher";
//	}
//
//	@RequestMapping(value = "/queryByteaName")
//	public String queryByname(String name, Model model) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		TeacherDao dao = (TeacherDao) context.getBean("teadao");
//		model.addAttribute("teachers", dao.queryByname(name));
//
//		return "teacher";
//	}
//
//	@RequestMapping(value = "/queryByteaId")
//	public String queryByid(int id, Model model) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		TeacherDao dao = (TeacherDao) context.getBean("teadao");
//		model.addAttribute("teachers", dao.queryByid(id));
//
//		return "teacher";
//
//	}
//
//	@RequestMapping(value = "/addtea")
//	public String AddTeacher(String name, String course, Model model) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		TeacherDao dao = (TeacherDao) context.getBean("teadao");
//		Teacher teacher = new Teacher();
//		teacher.setName(name);
//		teacher.setCourse(course);
//		boolean result = dao.addTea(teacher);
//		if (result) {
//			model.addAttribute("msg", "<script>alert()");
//		} else {
//			model.addAttribute("msg", "<script>alert()");
//		}
//		model.addAttribute("teachers", dao.queryAll());
//
//		return "teacher";
//	}
//
//	@RequestMapping(value = "/deleteByteaId")
//	public String deleteById(String id, Model model) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		TeacherDao dao = (TeacherDao) context.getBean("teadao");
//		boolean result = dao.deleteTea(Integer.parseInt(id));
//		if (result) {
//			System.out.println("削除成功");
//		} else {
//			System.out.println("削除失敗");
//		}
//		model.addAttribute("teachers", dao.queryAll());
//		return "teacher";
//
//	}
//
//	@RequestMapping(value = "/displaystudentList")
//
//	public String qreryAll(Model model) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		StudentDao dao = (StudentDao) context.getBean("dao");
//		List<Student> studentList = new ArrayList<Student>();
//		studentList = dao.queryAll();
//		model.addAttribute("studentList", studentList);
//
//		return "index";
//
//	}
//}