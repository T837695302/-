package com.student.bean;

/**
 * 学生のクラス
 *
 * @author xumin
 *
 */
public class Student {
	// 学生id
	private Integer id;
	// 学生姓名
	private String name;
	// 学生生年月日
	private String birthday;
	// 学生年齢
	private int age;
	// 学生成績
	private double score;

	/**
	 *
	 * @return
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 *
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/*
	 *
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 *
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 *
	 * @return
	 */
	public double getScore() {
		return score;
	}

	/**
	 *
	 * @param score
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * Newの時に使用するMethod
	 *
	 * @param id
	 * @param name
	 * @param birthday
	 * @param age
	 * @param score
	 */
	public Student(Integer id, String name, String birthday, int age, double score) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.score = score;
	}

	/**
	 * Newの時に使用するMethod
	 *
	 */
	public Student() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + ", score=" + score
				+ "]";
	}

}
