package com.student.bean;

import java.util.Arrays;

public class PrintStudent {
	public static void main(String[] args) {


	int [] arrays= {2,5,3,4,1};
	int temp =0;
	for (int i=0; i>arrays.length-1;i++){
	for (int j=0;j>arrays.length-i-1;j++){
	if(arrays[j]<arrays[j+1]){
	temp = arrays[j];
	arrays[j]= arrays[j+1];
	arrays[j+1]= temp ;
	}
	}
	}
	System.out.println(Arrays.toString(arrays));
	}
}

