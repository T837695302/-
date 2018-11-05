package com.student.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.student.bean.Teacher;
import com.teacher.dao.TeacherDao;

@Controller
public class StudentController {
	/**
	 *
	 * 从数据库中获取全部学生信息，将数据返回给主页index,jsp
	 *
	 * @param model
	 * @return 返回值类型： String
	 */
	@RequestMapping(value = "/all")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		// StudentDao dao = (StudentDao) context.getBean("dao");
		// model.addAttribute("students", dao.queryAll());
		// 从ioc容器中获取dao
		TeacherDao teacherdao = (TeacherDao) context.getBean("teacherdao");
		model.addAttribute("teachers", teacherdao.queryAll());
		// 从ioc容器中获取dao
		return "student";
	}

	/**
	 *
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryByNameTeac")
	public String queryByName(String teachername, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao teacherdao = (TeacherDao) context.getBean("teacherdao");
		model.addAttribute("teachers", teacherdao.queryByName(teachername));
		return "student";
	}

	/**
	 *
	 * @param name
	 * @param birthday
	 * @param age
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addTeac")
	public String addTeacher(String teachername, String course, Model model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao teacherdao = (TeacherDao) context.getBean("teacherdao");
		Teacher teacher = new Teacher();
		teacher.setTeachername(teachername);
		teacher.setCourse(course);
		model.addAttribute("teachers", teacherdao.queryAll());
		boolean result = teacherdao.addTeacher(teacher);

		if (result) {
			model.addAttribute("msg", "<script>alert('添加成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('添加失敗！')</script>");
		}

		model.addAttribute("teachers", teacherdao.queryAll());
		return "student";
	}

	/**
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteByIdTeac")
	public String deleteById(String id, Model model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao teacherdao = (TeacherDao) context.getBean("teacherdao");
		boolean result = teacherdao.deleteTeacher(Integer.parseInt(id));

		if (result) {
			model.addAttribute("msg", "<script>alert('削除成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('削除失敗！')</script>");
		}

		model.addAttribute("teachers", teacherdao.queryAll());
		return "student";

	}

	/**
	 *
	 * @param id
	 * @param name
	 * @param birthday
	 * @param age
	 */
	@RequestMapping(value = "/updateTeac")
	public String updateTeacher(String id, String teachername, String course, Model model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao teacherdao = (TeacherDao) context.getBean("teacherdao");
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(id));
		teacher.setTeachername(teachername);
		teacher.setCourse(course);

		boolean result = teacherdao.updateTeacher(teacher);

		if (result) {
			model.addAttribute("msg", "<script>alert('更新成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('更新失敗！')</script>");
		}

		model.addAttribute("teachers", teacherdao.queryAll());
		return "student";
	}

}
