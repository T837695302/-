/**
 *
 */
package com.student.bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author a
 *
 */
public class PrintStudent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student studentOne = new Student(1, "zhao", "2018-10-05", 9, 95);
		Student studentTwo = new Student(2, "qian", "2007-06-05", 10, 80);
		Student studentThree = new Student(3, "sun", "2009-01-05", 10, 80);
		Student studentFour = new Student(4, "liu", "2009-04-05", 10, 80);
		// list and map
		// ArrayList<型> 変数名 = new ArrayList<型>();
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(studentOne);
		studentList.add(studentTwo);
		studentList.add(studentThree);
		studentList.add(studentFour);

		// foreach（拡張for文）での書き方
		// 学生の1個ずつ取り出す
		for (Student value : studentList) {
			// 学生の1個ずつ渡してPrintStudentメソッドを呼び出し、表示処理
			PrintStudent(value);
		}

		// key,value
		HashMap<String, Student> Studentmap = new HashMap<String, Student>();
		Studentmap.put("1", studentOne);

		// 学生の1個渡してPrintStudentメソッドを呼び出し、表示処理
		PrintStudent(Studentmap.get("1"));

		// 学生の1個渡してPrintStudentメソッドを呼び出し、表示処理
		PrintStudent(Studentmap.get("2"));

		// 学生の1個渡してPrintStudentメソッドを呼び出し、表示処理
		PrintStudent(Studentmap.get("3"));

		// 学生の1個渡してPrintStudentメソッドを呼び出し、表示処理
		PrintStudent(Studentmap.get("4"));

		// foreach（拡張for文）での書き方
		for (Student stu : Studentmap.values()) {
			// 学生の1個渡してPrintStudentメソッドを呼び出し、表示処理
			PrintStudent(stu);
		}

		// student のhashMapをaverAgeStudentメソッドに渡して学生年齢の平均値を算出する
		System.out.print(averAgeStudent(Studentmap));

		// student のhashMapをaverScoreStudentメソッドに渡して学生成績の平均値を算出する
		System.out.print(averScoreStudent(Studentmap));
		System.out.print(averAgeStudent(studentList));

	}

	/**
	 * 学生の情報を印刷する
	 *
	 * @param Student
	 *            return
	 */
	private static void PrintStudent(Student stu) {
		System.out.println(stu.getAge());
		System.out.println(stu.getBirthday());
		System.out.println(stu.getName());
		System.out.println(stu.getScore());
		System.out.println(stu.getId());
	}

	/**
	 * 学生年齢の平均値
	 *
	 * @param Studet
	 *            hashmap return 学生年齢の平均値
	 *
	 */
	private static int averAgeStudent(ArrayList<Student> stuList) {
		int sum = 0;
		// foreach（拡張for文）での書き方
		for (Student stu : stuList) {
			// 学生の年齢を取り出して、合計する
			sum = sum + stu.getAge();
		}
		// 学生年齢の平均値を返す
		return sum /stuList.size();

	}

	/**
	 * 学生年齢の平均値
	 *
	 * @param Studet
	 *            hashmap return 学生年齢の平均値
	 *
	 */
	private static int averAgeStudent(HashMap<String, Student> stuMap) {
		int sum = 0;
		int averAgeStudent;
		// foreach（拡張for文）での書き方
		for (Student stu : stuMap.values()) {
			// 学生の年齢を取り出して、合計する
			sum = sum + stu.getAge();

		}
		// 学生年齢の平均値を返す
		return sum/stuMap.size();

	}

	/**
	 * 学生成績の平均値
	 *
	 * @param Studet
	 *            hashmap return 学生成績の平均値
	 *
	 */
	private static double averScoreStudent(HashMap<String, Student> stuMap) {
		double sum = 0;
		// foreach（拡張for文）での書き方
		for (Student stu : stuMap.values()) {
			// 学生の年齢を取り出して、合計する
			sum = sum + stu.getScore();

		}

		// 学生年齢の平均値を返す
		return sum / stuMap.size();
	}
}