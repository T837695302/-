package test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.student.bean.util.StringUtil;

public class BaseContent {

	public static void main(String[] args) {

//		 compare(3,3);
//		 compare(new Integer(3),new Integer(3));
//		 compare("a","b");
//		 addLong(5l,6l);
//
//		 romove(2,10);
//		 multiply(3,4);
//		 divide(12,5);
//		 mod(12, 7);
//		 divide(new BigDecimal("6"),new BigDecimal("3"));
//		 equals(new BigDecimal(4.0),new BigDecimal(4));
//		 beforeAddAdd();
//		 afterAddAdd();
//		 test();
//		logicNot(false);
//		logicNot(true);
//		vipjisan(true,500);
//		vipjisan(false,500);
//		logicOr(false,false);
//		logicOr(false,true);
//		logicOr(true,false);
//		logicOr(true,true);
//		ifMethod(true,false,true);
//List<String> strList=new ArrayList<>();
//strList.add("aaa");
//strList.add("bbb");
//strList.add("ccc");
//strJoin(strList);
//		List<BigDecimal>numList = new ArrayList<>();
//		numList.add(new BigDecimal("11.2"));
//		numList.add(new BigDecimal("12.2"));
//		numList.add(new BigDecimal("14.2"));
//		numList.add(new BigDecimal("6.773"));
//		List<BigDecimal>numListNull=null;
//		List<BigDecimal>numListEmpty=new ArrayList<>();
//add(numListEmpty);

//String str1 ="abc";
//String str2 ="";
//String str3 ="   ";
//String str4 =null;
//String str5 ="　　";
//
//boolean flag1 = StringUtil.isNotEmpty(str5);
//boolean flag2 = StringUtil.isEmpty(str5);
//if(flag1=!flag2) {
//
//}
//
//if (flag1) {
//System.out.println("youneirong");
//}else {
//	System.out.println("mei");
//}
String str ="abc1234";
str =StringUtil.allTrim(str);
boolean flag =StringUtil.isEN(str);
System.out.println(flag);





//
//			String str = "   a bc  ";
//			System.out.println("結果:"+StringUtil.allTrim(str));
//

		// addInteger(new Integer(3),new Integer(5));

		// StaticClass.staticMethod();
		//
		//
		// StaticClassTest staticClassTest = new StaticClassTest();
		// staticClassTest .notStatic();
		// staticClassTest .aaa();
	}

	private static void add(int num1, int num2) {

		int total = num1 + num2;
		System.out.println("パラメータ1:" + num1);
		System.out.println("パラメータ2:" + num2);
		System.out.println("計算結果:" + total);
	}

	private String addReturn(int num1, int num2) {

		int total = num1 + num2;
		return String.valueOf(total);
	}

	private static void addInteger(Integer num1, Integer num2) {
		int a = 5;

		Integer b = 5;

		int total = num1 + num2;
		System.out.println("パラメータ1:" + num1);
		System.out.println("パラメータ2:" + num2);
		System.out.println("計算結果:" + total);
	}

	private static void addLong(Long l1, Long l2) {
		long total = l1 + l2;
	}

	private static void compare(Integer num1, Integer num2) {
		if (num1 == num2) {
			System.out.println("一致");

		} else {
			System.out.println("不一致");
		}
	}

	private static void compare(String str1, String str2) {
		if (str1.equals(str2)) {
			System.out.println("一致");
		} else {
			System.out.println("不一致");
		}

	}

	private static void romove(int num1, int num2) {
		int returnNum = num1 - num2;
		System.out.println("結果:" + returnNum);
	}

	private static void multiply(int num1, int num2) {
		int returnNum = num1 * num2;

	}

	private static void divide(int num1, int num2) {
		int retrunNum = num1 / num2;

		System.out.println("結果:" + retrunNum);

	}

	private static void mod(int num1, int num2) {
		int retrunNum = num1 % num2;
		System.out.println("結果:" + retrunNum);
	}

	private static void divide(BigDecimal num1, BigDecimal num2) {
		BigDecimal retrunNum = num1.divide(num2, 2, RoundingMode.HALF_UP);
		System.out.println("結果:" + retrunNum);
	}

	private static void equals(BigDecimal num1, BigDecimal num2) {
		if (num1.compareTo(num2) == 0) {
			System.out.println("一致");
		} else {
			System.out.println("不一致");
		}

	}

	private static void beforeAddAdd() {
		System.out.println("beforeAddAdd.........start:");

		for (int i = 0; i < 10; ++i) {
			System.out.println("i=:" + i);
		}
		System.out.println("beforeAddAdd.........end:");
	}

	private static void afterAddAdd() {
		System.out.println("afterAddAdd.........start:");

		for (int i = 0; i < 10; i++) {
			System.out.println("i=:" + i);
		}
		System.out.println("afterAddAdd.........end:");

	}

	private static void test() {
		int d = 25;
		System.out.println("d++ =:" + (d++));
		System.out.println("++d =:" + (++d));
		System.out.println("d-- =:" + (d--));
		System.out.println("--d =:" + (--d));
	}

	private static void logicNot(boolean flag) {
		if (!flag) {
			System.out.println(flag + "非:" + "true");
		} else {
			System.out.println(flag + "非:" + "false");
		}
	}

	private static void vipjisan(boolean vipFlag, double num) {
		double cost = 0;
		if (vipFlag) {
			cost = num * 0.8;
		} else {
			cost = num;

		}
		System.out.println("zonghuafeishi:" + cost);
	}

	private static void logicAnd(boolean flag1,boolean flag2) {
		if (flag1&&flag2) {
			System.out.println("and:" + true);
		}else {
			System.out.println("and:" + false);

		}
	}
	private static void logicOr(boolean flag1,boolean flag2) {
		if (flag1||flag2) {
			System.out.println("and:" + true);
		}else {
			System.out.println("and:" + false);

		}
	}
	private static void ifMethod(boolean ... flags) {
		if(flags[0]) {
			if(flags[2]) {
				System.out.println("diyidisantrue" );
			}
			System.out.println("diyitrue" );
			}else if(flags[1]) {
				System.out.println("diertrue" );
			}else {
				System.out.println("doushifalse" );

			}
	}


	private static void strJoin(String str1,String str2) {
	String str =str1+str2;
	System.out.println(str);

		}

	private  static void strJoin(List<String>strList) {
		StringBuilder strJoinResult = new StringBuilder();
		for (String str:strList) {
			strJoinResult.append(str);
			strJoinResult.append(",");
			strJoinResult.append("\r\n");

		}
		System.out.println(strJoinResult.toString());

	}
	private static void add(List<BigDecimal>numList) {
		BigDecimal total = new BigDecimal("0");
if(numList!=null && numList.size()>0) {
	for (BigDecimal num:numList) {
total = total.add(num);
	}

	System.out.println("合計:"+total.toPlainString());
}else {
	System.out.println("入力存在ない");
}

}


}