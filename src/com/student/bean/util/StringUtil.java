package com.student.bean.util;

import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 文字列存在判定.
	 * @param str　文字列.
	 * @return　判定結果.
	 */
public static boolean isEmpty(String str) {
	if ( str==null || allTrim(str).length()==0) {
		return true;

	}else {
		return false;
	}

}
public static boolean isNotEmpty(String str) {
	if (str!=null&&allTrim(str).length()!=0) {
		return true;
	}else {
		return false;
	}
}
public static String leftTrim(String str) {

	String trimEdStr = "";
	if(str ==null) {
		return str;
	}else {
		char[] chars = str.toCharArray();
		int indexStrat=0;
		for (char charc:chars) {
			if(' '==charc||'　'==charc) {
				indexStrat++;
			}else {
				break;
			}
		}
		trimEdStr=str.substring(indexStrat);
		return trimEdStr;
	}
}
public static String rightTrim(String str) {

	String trimEdStr = "";
	if(str ==null) {
		return trimEdStr;
	}else {
		char[] chars = str.toCharArray();
		int indexEnd=chars.length;
		for (int index=chars.length-1;index>=0;index--) {
			if(' '==chars[index]||'　'==chars[index]) {
                indexEnd--;
			}else {
				break;
			}
		}

		trimEdStr=str.substring(0,indexEnd);
		return trimEdStr;
	}
}
public static String allTrim(String str) {

return leftTrim(rightTrim(str));

}
public static boolean isEN(String str) {
	if (str==null) {
		return false;

	}
	String pattern= "^[0-9]+$";


	return Pattern.matches(pattern, str);

}

}



