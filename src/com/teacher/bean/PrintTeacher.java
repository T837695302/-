/**
 *
 */
package com.teacher.bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 先生印刷用クラス
 *
 * @author xumin
 *
 */
public class PrintTeacher {

	/**
	 * メインメソッド(Main Method)
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// 先生１を生成する
		Teacher teacherOne = new Teacher();
		teacherOne.setId(100);
		teacherOne.setTeachername("sun");
		teacherOne.setCourse("php");
		System.out.println("Id:" + teacherOne.getId());
		System.out.println("teacherName:" + teacherOne.getTeachername());
		System.out.println("course:" + teacherOne.getCourse());
		// 先生2を生成する
		Teacher teacherTwo = new Teacher();
		teacherTwo.setId(2);
		teacherTwo.setTeachername("li");
		teacherTwo.setCourse("chinese");
		System.out.println("Id:" + teacherTwo.getId());
		System.out.println("teacherName:" + teacherTwo.getTeachername());
		System.out.println("course:" + teacherTwo.getCourse());
		// 先生3を生成する
		Teacher teacherThree = new Teacher();
		teacherThree.setId(3);
		teacherThree.setTeachername("zhao");
		teacherThree.setCourse("Japanese");

		System.out.println("Id:" + teacherThree.getId());
		System.out.println("TteacherName:" + teacherThree.getTeachername());
		System.out.println("couese:" + teacherThree.getCourse());
		// 先生4を生成する
		Teacher teacherFour = new Teacher();
		teacherFour.setId(4);
		teacherFour.setTeachername("qian");
		teacherFour.setCourse("Music");
		System.out.println("Id:" + teacherFour.getId());
		System.out.println("teacherName:" + teacherFour.getTeachername());
		System.out.println("course:" + teacherFour.getCourse());
		// 先生5を生成する
		Teacher teacherFive = new Teacher(5, "tea05", "german");
		// 先生6を生成する
		Teacher teacherSix = new Teacher(1, "tea06", "german");
		System.out.println(teacherFive.toString());
		// リストを生成する
		ArrayList<Teacher> teacherlist = new ArrayList<Teacher>();
		teacherlist.add(teacherOne);
		teacherlist.add(teacherTwo);
		teacherlist.add(teacherThree);
		teacherlist.add(teacherFour);
		teacherlist.add(teacherFive);
		teacherlist.add(teacherSix);
	//先生リストを印刷する
		for (Teacher value : teacherlist) {
			System.out.println("teacherlist:" + value.toString());
		}
		//teacherMapを生成する
		HashMap<Integer,Teacher> teachermap = new HashMap<Integer,Teacher>();
		teachermap.put(100, teacherOne);
		teachermap.put(2,teacherTwo);
		teachermap.put(3,teacherThree);
		teachermap.put(4,teacherFour);
		teachermap.put(5,teacherFive);
		teachermap.put(1,teacherSix);

    //数値は一番大きな先生idを印刷
		int maxTeacherId = CalculateMaxId(teacherlist);
		System.out.println("数値は一番大きなid:" + maxTeacherId);
		//数値は一番小さな先生idを印刷
		int minTeacherId = CalculateMinId(teacherlist);
		System.out.println("数値は一番小さなid:" + minTeacherId);
		//先生idの平均値を印刷
		int aveTeacherId = CalculateAveId(teacherlist);
		System.out.println("idの平均値:" +aveTeacherId);

	}

	/**
	 *
	 * 最大のIDを計算する
	 *
	 * @param teacherlist（先生一覧リスト）
	 * @return最大のID
	 */
	private static int CalculateMaxId(ArrayList<Teacher> teacherlist) {
		// TODO 自動生成されたメソッド・スタブ
		int maxTeacherId = 0;
		// foreach（拡張for文）での書き方
		for (Teacher teacher : teacherlist) {
			// 先生のidを取り出して、合計する
			if (maxTeacherId < teacher.getId()) {
				maxTeacherId = teacher.getId();
			}

		}
		//先生idの最大値を返す
		return maxTeacherId;
	}

	/**
	 *
	 * 最小のIDを計算する
	 *
	 * @param teacherlist（先生一覧リスト）
	 * @return最大のID
	 */
	private static int CalculateMinId(ArrayList<Teacher> teacherlist) {
		// TODO 自動生成されたメソッド・スタブ
		int minTeacherId = teacherlist.get(0).getId();
		// foreach（拡張for文）での書き方
		for (Teacher teacher : teacherlist) {
			// 先生のidを取り出して、合計する
			if (minTeacherId > teacher.getId()) {
				minTeacherId = teacher.getId();
			}

		}
		// 先生idの最小値を返す
		return minTeacherId;
	}

	/**
	 *
	 * 平均のIDを計算する
	 *
	 * @param teacherlist
	 * @return
	 */
	private static int CalculateAveId(ArrayList<Teacher> teacherlist) {

		int sum=0;
		int aveTeacherId=0;
		//foreach（拡張for文）での書き方
		for (Teacher teacher : teacherlist) {
			// 先生のidを取り出して、合計する
			sum=sum+teacher.getId();
			 aveTeacherId=sum/teacherlist.size();
		}

		return aveTeacherId;
	}
 }
