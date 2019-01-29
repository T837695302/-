package com.teacher.bean;

public class Teacher {
private int id;
private String name;
private String course;
/**
 * @return id
 */
public int getId() {
	return id;
}
/**
 * @param id セットする id
 */
public  void setId(int id) {
	this.id = id;
}
/**
 * @return name
 */
public String getName() {
	return name;
}
/**
 * @param name セットする name
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return course
 */
public String getCourse() {
	return course;
}
/**
 * @param course セットする course
 */
public void setCourse(String course) {
	this.course = course;
}
/* (非 Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Teacher [id=" + id + ", name=" + name + ", course=" + course + "]";
}
/**
 * @param id
 * @param name
 * @param course
 */
public Teacher(int id, String name, String course) {
	super();
	this.id = id;
	this.name = name;
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
