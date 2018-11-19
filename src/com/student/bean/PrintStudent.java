/**
 *
 */
package com.student.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sekii
 *
 */
public class PrintStudent {
	/**
	 * 初期値=0 	定义常量的可维护性高
	 */

	private static final double BUSINESS_ZERO = 0;

	/**
		 * @param args
		 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Student studentOne = new Student(1, "zhao", "2018-10-05", 9, 95, 1);
		Student studentTwo = new Student(2, "qian", "2007-06-05", 10, 80, 1);
		Student studentThree = new Student(3, "sun", "2009-01-05", 10, 80, 1);

		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(studentOne);
		studentList.add(studentTwo);
		studentList.add(studentThree);

		//	double sumScore = getSumStudentScore(studentList);
		//	System.out.println("学生成績合計：" +  getSumStudentScore(studentList));
		double caerScore = getAverStudentScore(studentList);
		System.out.println("学生成績平均値：" + getAverStudentScore(studentList));

		Map<String, Student> studentMap = new HashMap<>();


		studentMap.get("1");
			System.out.println("1対応する学生：" + studentMap.get("1"));
		//	System.out.println("2対応する学生：" + studentMap.get("2"));
		//	System.out.println("3対応する学生：" + studentMap.get("3"));
		Map<Integer, Student> studentMap2 = new HashMap<>();
		studentMap2.put(1, studentOne);
		studentMap2.put(2, studentTwo);
		studentMap2.put(3, studentThree);

		//	System.out.println("1対応する学生"+studentMap2.get(1));
		//System.out.println("2対応する学生"+studentMap2.get(2));
		//System.out.println("3対応する学生"+studentMap2.get(3));
		//Map 循环
		//set<Integer>Keysets=studentMap2.keySet();
		for (Student student : studentMap2.values()) {
			System.out.println(student);
		}
		for (Student student : studentMap2.values())
			System.out.println(student.getScore());
		double maxScore = getMaxStudentScore(studentMap2);
		System.out.println("学生マップの最大値" + maxScore);
		double minScore = getMinStudentScore(studentMap2);
		System.out.println("学生マップの最小値" + minScore);
		double sumScore=getSumStudentScore(studentMap2);
		System.out.println("学生成績合計："+sumScore);
		double aveScore=getaveStudentScore(studentMap2);
		boolean failScore=getStudentScoreFail(studentMap2);
		if(failScore==false) {
			System.out.println("成績不合格の学生が存在"+failScore);}
			else {
				System.out.println("成績不合格の学生が不存在"+failScore);
			}
		}




	 // ①マップ、リストに、不及格学生存在のメソッド
/**
 * 成績不合格の学生存在するチェック
 * @param studentMap2 学生マップ
 * @return　存在フラグ
 */
	private static boolean getStudentScoreFail(Map<Integer,Student>studentMap2) {
		boolean failScore=false;
		for(Student student:studentMap2.values()) {
			if(student.getScore()<60)
				{failScore=true;
				break;
				}
			else{return failScore=false;
			}
			}
		return failScore;
	}
	/**
	 * ②マップ、リストに、学生全部及格のメソッド
	 */
	/**
	 * 学生成績の平均値
	 * @param studentMap　学生マップ
	 * @return　平均値
	 */
	private static double getaveStudentScore(Map<Integer,Student>studentMap) {
		double aveScore=0;
		double sumScore=getSumStudentScore(studentMap);
		aveScore=sumScore/studentMap.size();
		return aveScore;
	}

/**
 * 学生成績合計取得する。
 * @return 学生成績合計
 */
	private static double getSumStudentScore(Map<Integer,Student>studentMap2) {
		double sumScore=0;
		for(Student student:studentMap2.values()) {
			sumScore=sumScore+student.getScore();

		}
		return sumScore;
	}
/**
 * 最小値を取得する
 * @param studentMap2　学生マップ
 * @return　最小値
 */
	private static double getMinStudentScore(Map<Integer,Student>studentMap2) {
double minScore=0;
double num=0;
for(Student student:studentMap2.values()) {
	if(num==0) {minScore=student.getScore();
	num++;}

	else{
		if(student.getScore()<minScore) {
		minScore=student.getScore();
		}
	}
}
return minScore;
	}

	/**
	 * 最大値を取得する。
	 * @param studentMap　学生マップ
	 * @return　最大値
	 */
	private static double getMaxStudentScore(Map<Integer, Student> studentMap) {
		double maxScore = 0;
		for (Student student : studentMap.values()) {
			if (maxScore < student.getScore()) {
				maxScore = student.getScore();
			}
		}
		return maxScore;
	}

	/*	private static double getSumStudentScore(ArrayList<Student> studentList) {
			// TODO 自動生成されたメソッド・スタブ

			/**
			 * 学生成績合計を取得する。
			 * @param studentList　学生情報リスト
			private static double getSumStudentScore(List<Student> studentList) {
			 * @return　学生成績合計
			 */

	private static double getSumStudentScore(List<Student> studentList) {
		double ScoreTotal = 0;
		for (Student student : studentList) {
			ScoreTotal = ScoreTotal + student.getScore();
		}
		return ScoreTotal;
	}

	/**
	 * 学生成績の平均値
	 * @param studentList　学生情報リスト
	 * @return　　学生成績の平均値
	 */
/*	private static double getAverStudentScore(List<Student> studentList) {
		double averScore = 0;
		double scoreTotal = 0;
		for (Student student : studentList) {
			scoreTotal = scoreTotal + student.getScore();
		}
		averScore = scoreTotal / studentList.size();

		return averScore;

	}*/
	private static double getAverStudentScore(List<Student> studentList) {
		double averScore = 0;
		averScore=getSumStudentScore(studentList)/studentList.size();
		return averScore;

	}
}
