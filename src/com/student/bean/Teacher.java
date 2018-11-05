package com.student.bean;

/**
 * 学生のクラス
 *
 * @author xumin
 *
 */
public class Teacher {
	// 学生id
	private Integer id;
	// 学生姓名
	private String teachername;
	// 学生生年月日
	private String course;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            セットする id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return teachername
	 */
	public String getTeachername() {
		return teachername;
	}

	/**
	 * @param teachername
	 *            セットする teachername
	 */
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	/**
	 * @return course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            セットする course
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teachername=" + teachername + ", course=" + course + "]";
	}

	/**
	 * @param id
	 * @param teachername
	 * @param course
	 */
	public Teacher(Integer id, String teachername, String course) {
		super();
		this.id = id;
		this.teachername = teachername;
		this.course = course;
	}

	/**
	 *
	 */
	public Teacher() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
