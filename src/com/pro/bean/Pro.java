package com.pro.bean;

public class Pro {
private int id;
private String name;
private String weight;

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
 * @return weight
 */
public String getWeight() {
	return weight;
}

/**
 * @param weight セットする weight
 */
public void setWeight(String weight) {
	this.weight = weight;
}

/* (非 Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Pro [id=" + id + ", name=" + name + ", weight=" + weight + "]";
}

/**
 * @param id
 * @param name
 * @param weight
 */
public Pro(int id, String name, String weight) {
	super();
	this.id = id;
	this.name = name;
	this.weight = weight;
}




/**
*
*/
public Pro() {
	super();
	// TODO 自動生成されたコンストラクター・スタブ
}

}