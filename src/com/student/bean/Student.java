package com.student.bean;

public class Student {
private int id;
private String name;
private String birthday;
private int age;
private int score;
private int classid;

/**
 * @return id
 */
public int getId() {
	return id;
}
/**
 * @param id セットする id
 */
public void setId(int id) {
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
 * @return birthday
 */
public String getBirthday() {
	return birthday;
}
/**
 * @param birthday セットする birthday
 */
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
/**
 * @return age
 */
public int getAge() {
	return age;
}
/**
 * @param age セットする age
 */
public void setAge(int age) {
	this.age = age;
}
/**
 * @return score
 */
public int getScore() {
	return score;
}
/**
 * @param score セットする score
 */
public void setScore(int score) {
	this.score = score;
}
/**
 * @return classid
 */
public int getClassid() {
	return classid;
}
/**
 * @param classid セットする classid
 */
public void setClassid(int classid) {
	this.classid = classid;
}

/* (非 Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + ", score=" + score
			+ ", classid=" + classid + "]";
}
/**
 * @param id
 * @param name
 * @param birthday
 * @param age
 * @param score
 * @param classid
 * @param address
 */
public Student(int id, String name, String birthday, int age, int score, int classid) {
	super();
	this.id = id;
	this.name = name;
	this.birthday = birthday;
	this.age = age;
	this.score = score;
	this.classid = classid;

}
/**
 *
 */
public Student() {
	super();
	// TODO 自動生成されたコンストラクター・スタブ
}
public Object getAddress() {
	// TODO 自動生成されたメソッド・スタブ
	return "index";
}

}


