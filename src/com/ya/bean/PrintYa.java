package com.ya.bean;

import java.util.ArrayList;
import java.util.List;

public class PrintYa {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
Ya yaOne = new Ya();
yaOne.setId(1);
yaOne.setName("li");
yaOne.setHobby("walking");
yaOne.setHeight(160);
yaOne.setWeight(50);

Ya yaTwo = new Ya();
yaTwo.setId(2);
yaTwo.setName("an");
yaTwo.setHobby("shasha");
yaTwo.setHeight(150);
yaTwo.setWeight(40);

Ya yaThree = new Ya();
yaThree.setId(3);
yaThree.setName("lin");
yaThree.setHobby("jumpping");
yaThree.setHeight(156);
yaThree.setWeight(47);

Ya yaFour = new Ya();
yaFour.setId(4);
yaFour.setName("xi");
yaFour.setHobby("walking");
yaFour.setHeight(150);
yaFour.setWeight(45);

Ya yaFive = new Ya(5,"shan","swimming",140,30);
Ya yaSix = new Ya(6,"shang","ridding",150,50);
Ya yaSeven = new Ya(7,"lan","smile",158,52);


List<Ya> yaList = new ArrayList<Ya>();
yaList.add(yaOne);
 yaList.add(yaTwo);
 yaList.add(yaThree);
 yaList.add(yaFour);
 yaList.add(yaFive);
 yaList.add(yaSix);
 yaList.add(yaSeven);

 System.out.println(yaList);

	}

}
