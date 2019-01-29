package com.student.controller;

import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping(value = "/all")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");

		model.addAttribute("students", dao.queryAll());
		return "index";
	}

	@RequestMapping(value = "/queryByName")
	public String queryByName(String name, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryByname(name));
		return "index";
	}

	@RequestMapping(value = "/queryByclassid")
	public String queryByclassid(int classid, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryByclassid(classid));
		return "index";
	}

	@RequestMapping(value = "/queryByid")
	public String queryByid(int id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryByid(id));

		return "index";
	}

	@RequestMapping(value = "/deleteById")
	public String deleteById(String id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		boolean result = dao.deleteStu(Integer.parseInt(id));
		if (result) {
			System.out.println("削除成功");
		} else {
			System.out.println("削除失敗");
		}
		model.addAttribute("students", dao.queryAll());
		return "index";

	}

	@RequestMapping(value = "/add")
	public String AddStudent(String name, String brithday, String age, String score, String classid, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		Student student = new Student();
		student.setName(name);
		student.setBirthday(brithday);
		student.setAge(Integer.valueOf(age));
		student.setScore(Integer.valueOf(score));
		student.setClassid(Integer.valueOf(classid));

		boolean result = dao.addStu(student);
		if (result) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
		return "index";
	}
//	if (result) {
//		 model.addAttribute("msg", "<script>alert()");
//		 } else {
//		 model.addAttribute("msg", "<script>alert()");
//		 }
//		 model.addAttribute("students", dao.queryAll());
//
//		 return "index";
//		 }


	@RequestMapping(value = "/displayteaList")
	public String queryAlltea(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao dao = (TeacherDao) context.getBean("teadao");
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = dao.queryAll();
		model.addAttribute("teachers", teacherList);
		return "teacher";
	}

 @RequestMapping(value = "/update")
 public String UpdateStudent(String id,String name, String brithday,String
 age,String score,String classid, Model model) {
 ApplicationContext context = new
 ClassPathXmlApplicationContext("applicationContext.xml");
 StudentDao dao = (StudentDao) context.getBean("dao");
 Student student = new Student();
 student.setId(Integer.parseInt(id));
 student.setName(name);
 student.setBirthday(brithday);
 student.setAge(Integer.parseInt(age));
 student.setScore(Integer.parseInt(score));
 student.setClassid(Integer.parseInt(classid));

 boolean result = dao.updateStu(student);
 if(result) {
 System.out.println("ok");
 }else{
 System.out.println("no");
 }
 model.addAttribute("students",dao.queryAll());
 return "index";
 }



@RequestMapping(value = "addaddress")
	 public String AddaddressStudent(String address, Model model) {
			 ApplicationContext context = new
			 ClassPathXmlApplicationContext("applicationContext.xml");
			 StudentDao dao = (StudentDao) context.getBean("dao");
			 model.addAttribute("students",dao.addaddressStu(address));

	return "index";
}
}
// @RequestMapping(value = "/displsayGoodController")
// public String displayGoodScore(Model model) {
// List<Student> goodList=getStudentList();
// BigDecimal average=getAverage(goodList);
// List<Student> returnList=getReturnList(goodList, average);
// model.addAttribute("students", returnList);
// return "index";
// }
//
// public List<Student> getStudentList() {
// ApplicationContext context = new
// ClassPathXmlApplicationContext("applicationContext.xml");
// StudentDao dao = (StudentDao)context.getBean("dao");
// List<Student> goodList=new ArrayList<Student>();
// goodList=dao.queryAll();
// return goodList;
// }
//
// private BigDecimal getAverage(List<Student> goodList) {
// BigDecimal average=BigDecimal.ZERO;
// for(Student student : goodList) {
// average=average.add(new BigDecimal(student.getScore()));
// }
//
// return average.divide(new BigDecimal(goodList.size()), 2,
// RoundingMode.HALF_UP);
//
// }
// private List<Student> getReturnList(List<Student> goodList,BigDecimal
// average){
// List<Student> returnList=new ArrayList<>();
// for(Student student : goodList) {
// if(new BigDecimal(student.getScore()).compareTo(average)>0) {
// returnList.add(student);
// }
// }
// return returnList;
// }
//
//
// @RequestMapping(value = "/displayGokakuController")
// public String displayGokakuController(Model model) {
// List<Student> GokakustudentList=getStudentList();
// List<Student> returnList=getGokakuStudentList(GokakustudentList);
// model.addAttribute("students", returnList);
// return "index";
// }
//
// private List<Student> getGokakuStudentList(List<Student> passStudentList){
// List<Student> returnList=new ArrayList<>();
// for(Student student : passStudentList) {
// if(student.getScore()>=60) {
// returnList.add(student);
// }
// }
// return returnList;
// }
// }

// @RequestMapping(value = "/displayAverScoreController")
// public String getAverScoreByClassId(Model model) {
//
// List<Student> studentList=getStudentList();
//
// List<ClassScoreForm> classScoreFormList=new ArrayList<>();
// Map<Integer, CountScoreDto> map=new HashMap<>();
//
//
// for(Student student : studentList) {
// int classid=student.getClassid();
// CountScoreDto countScoreDto=map.get(classid);
//
// if(countScoreDto==null) {
// countScoreDto=new CountScoreDto();
// countScoreDto.setClassId(classid);
// map.put(classid,countScoreDto);
// }
//
// countScoreDto.setCount(countScoreDto.getCount()+1);
// countScoreDto.setSumScore(countScoreDto.getSumScore()+student.getScore());
// }
//
// for(CountScoreDto countScoreDto:map.values()) {
//
// BigDecimal averScore=new BigDecimal(countScoreDto.getSumScore())
// .divide(new BigDecimal(countScoreDto.getCount()), 2, RoundingMode.HALF_UP);
//// BigDecimal firstNum=new BigDecimal(countScoreDto.getSumScore());
//// BigDecimal secNum=new BigDecimal(countScoreDto.getCount());
//// BigDecimal averScore=firstNum.divide(secNum, 2, RoundingMode.HALF_UP);
//
// ClassScoreForm classScoreForm=new ClassScoreForm();
// classScoreForm.setClassId(countScoreDto.getClassId());
// classScoreForm.setAverScore(averScore.intValue());
//
// classScoreFormList.add(classScoreForm);
// }
//
// model.addAttribute("classScoreFormList", classScoreFormList);
// return "index";
// }
//
// }
//
//
