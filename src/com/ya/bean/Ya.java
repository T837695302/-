package com.ya.bean;

public class Ya {
private int id;
private String name;
private String hobby;
private int height;
private int weight;
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
 * @return hobby
 */
public String getHobby() {
	return hobby;
}
/**
 * @param hobby セットする hobby
 */
public void setHobby(String hobby) {
	this.hobby = hobby;
}
/**
 * @return height
 */
public int getHeight() {
	return height;
}
/**
 * @param height セットする height
 */
public void setHeight(int height) {
	this.height = height;
}
/**
 * @return weight
 */
public int getWeight() {
	return weight;
}
/**
 * @param weight セットする weight
 */
public void setWeight(int weight) {
	this.weight = weight;
}
/* (非 Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Ya [id=" + id + ", name=" + name + ", hobby=" + hobby + ", height=" + height + ", weight=" + weight + "]";
}
/**
 * @param id
 * @param name
 * @param hobby
 * @param height
 * @param weight
 */
public Ya(int id, String name, String hobby, int height, int weight) {
	super();
	this.id = id;
	this.name = name;
	this.hobby = hobby;
	this.height = height;
	this.weight = weight;
}
/**
 *
 */
public Ya() {
	super();
	// TODO 自動生成されたコンストラクター・スタブ
}

}
