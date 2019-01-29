package com.aaa.bean;

import java.util.ArrayList;
import java.util.List;



public class PrintAaa {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
Aaa aaaOne= new Aaa();
aaaOne.setId(1);
aaaOne.setName("xiangzao");
aaaOne.setPlace("riben");
aaaOne.setWeight(80);
aaaOne.setLine(2);
aaaOne.setAddress("?");

Aaa aaaTwo= new Aaa();
aaaTwo.setId(2);
aaaTwo.setName("yagao");
aaaTwo.setPlace("helan");
aaaTwo.setWeight(60);
aaaTwo.setLine(2);
aaaTwo.setAddress("?");

Aaa aaaThree= new Aaa();
aaaThree.setId(3);
aaaThree.setName("xiyifen");
aaaThree.setPlace("China");
aaaThree.setWeight(400);
aaaThree.setLine(1);
aaaThree.setAddress("?");



List<Aaa> aaaList = new ArrayList<Aaa>();
aaaList.add(aaaOne);
aaaList.add(aaaTwo);
aaaList.add(aaaThree);


System.out.println(aaaList);


	}

}
