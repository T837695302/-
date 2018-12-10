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
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((course == null) ? 0 : course.hashCode());
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
/* (非 Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Teacher other = (Teacher) obj;
	if (course == null) {
		if (other.course != null)
			return false;
	} else if (!course.equals(other.course))
		return false;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}
/* (非 Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Teacher [id=" + id + ", name=" + name + ", course=" + course + "]";
}
/**
 *
 */
public Teacher() {
	super();
	// TODO 自動生成されたコンストラクター・スタブ
}

}
