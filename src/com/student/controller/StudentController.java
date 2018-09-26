package com.student.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.bean.Student;
import com.student.dao.StudentDao;
import com.teacher.bean.Teacher;
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
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryAll());
		// 从ioc容器中获取dao

		return "student";
	}

	/**
	 *
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryByName")
	public String queryByName(String name, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryByName(name));
		return "student";
	}

	/**
	 *
	 * @param name
	 * @param birthday
	 * @param age
	 * @param score
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add")
	public String addStudent(String name, String birthday, String age, String score, Model model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		Student student = new Student();
		student.setName(name);
		student.setBirthday(birthday);
		student.setAge(Integer.valueOf(age));
		student.setScore(Double.parseDouble(score));

		boolean result = dao.AddStudent(student);

		if (result) {
			model.addAttribute("msg", "<script>alert('添加成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('添加失敗！')</script>");
		}

		model.addAttribute("students", dao.queryAll());
		return "student";
	}

	/**
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "deleteById")
	public String deleteById(String id, Model model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");

		boolean result = dao.DeleteStudent(Integer.parseInt(id));

		if (result) {
			model.addAttribute("msg", "<script>alert('削除成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('削除失敗！')</script>");
		}

		model.addAttribute("students", dao.queryAll());
		return "student";

	}

	/**
	 *
	 * @param id
	 * @param name
	 * @param birthday
	 * @param age
	 * @param score
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update")
	public String updateStudent(String id, String name, String birthday, String age, String score, Model model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		Student student = new Student();
		student.setId(Integer.parseInt(id));
		student.setName(name);
		student.setBirthday(birthday);
		student.setAge(Integer.valueOf(age));
		student.setScore(Double.parseDouble(score));

		boolean result = dao.AddStudent(student);

		if (result) {
			model.addAttribute("msg", "<script>alert('更新成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('更新失敗！')</script>");
		}

		model.addAttribute("students", dao.queryAll());
		return "student";
	}

	/**
	 *
	 * 从数据库中获取全部教師信息，将数据返回给主页index,jsp
	 *
	 * @param model
	 * @return 返回值类型： String
	 */
	@RequestMapping(value = "/allTeac")
	public String queryTeacAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		TeacherDao dao = (TeacherDao) context.getBean("teadao");
		model.addAttribute("teachers", dao.queryAll());
		// 从ioc容器中获取dao

		return "teacher";
	}

	/**
	 *
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryByNameTeac")
	public String queryByNameTeac(String name, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		TeacherDao dao = (TeacherDao) context.getBean("teadao");
		model.addAttribute("teachers", dao.queryByName(name));
		return "teacher";
	}

	/**
	 *
	 * @param name
	 * @param birthday
	 * @param age
	 * @param score
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addTeac")
	public String addTeac(String name, String course, Model model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao dao = (TeacherDao) context.getBean("teadao");
		Teacher teacher = new Teacher();
		teacher.setTeachername(name);
		teacher.setCourse(course);

		boolean result = dao.addTeacher(teacher);

		if (result) {
			model.addAttribute("msg", "<script>alert('添加成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('添加失敗！')</script>");
		}

		model.addAttribute("teachers", dao.queryAll());
		return "teacher";
	}

	/**
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "deleteByIdTeac")
	public String deleteByIdTeac(String id, Model model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao dao = (TeacherDao) context.getBean("teadao");

		boolean result = dao.deleteTeacher(Integer.parseInt(id));

		if (result) {
			model.addAttribute("msg", "<script>alert('削除成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('削除失敗！')</script>");
		}

		model.addAttribute("teachers", dao.queryAll());
		return "teacher";

	}

	/**
	 *
	 * @param id
	 * @param name
	 * @param birthday
	 * @param age
	 * @param score
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "updateTeac")
	public String updateTeac(String id, String name, String course, Model model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao dao = (TeacherDao) context.getBean("teadao");
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(id));
		teacher.setTeachername(name);
		teacher.setCourse(course);


		boolean result = dao.addTeacher(teacher);

		if (result) {
			model.addAttribute("msg", "<script>alert('更新成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('更新失敗！')</script>");
		}

		model.addAttribute("teachers", dao.queryAll());
		return "teacher";
	}
}
