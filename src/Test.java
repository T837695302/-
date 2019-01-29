import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
	     int a = 10;
	     int b = 20;
	     int c = 25;
	     int d = 25;
	     System.out.println("a + b = " + (a + b) );
	     System.out.println("a - b = " + (a - b) );
	     System.out.println("a * b = " + (a * b) );
	     System.out.println("b / a = " + (b / a) );
	     System.out.println("b % a = " + (b % a) );
	     System.out.println("c % a = " + (c % a) );
	     System.out.println("a++   = " +  (a++) );
	     System.out.println("a--   = " +  (a--) );
	     // 查看  d++ 与 ++d 的不同
	     System.out.println("d++   = " +  (d++) );
	     System.out.println("++d   = " +  (++d) );


	 a = 10;
     b = 20;
     c = 0;
    c = a + b;
    System.out.println("c = a + b = " + c );
    c += a ;
    System.out.println("c += a  = " + c );
    c -= a ;
    System.out.println("c -= a = " + c );
    c *= a ;
    System.out.println("c *= a = " + c );
    a = 10;
    c = 15;
    c /= a ;
    System.out.println("c /= a = " + c );
    a = 10;
    c = 15;
    c %= a ;
    System.out.println("c %= a  = " + c );
    c <<= 2 ;
    System.out.println("c <<= 2 = " + c );
    c >>= 2 ;
    System.out.println("c >>= 2 = " + c );
    c >>= 2 ;
    System.out.println("c >>= 2 = " + c );
    c &= a ;
    System.out.println("c &= a  = " + c );
    c ^= a ;
    System.out.println("c ^= a   = " + c );
    c |= a ;
    System.out.println("c |= a   = " + c );


    System.out.println("Hello World");

    int[] arrays = {2, 5, 1, 3, 4};
	 int temp=0;

       //外层循环是排序的趟数
       for (int i = 0; i < arrays.length - 1 ; i++) {

           //内层循环是当前趟数需要比较的次数
           for (int j = 0; j < arrays.length - i - 1; j++) {

               //前一位与后一位与前一位比较，如果前一位比后一位要大，那么交换
               if (arrays[j] > arrays[j + 1]) {
                   temp = arrays[j];
                   arrays[j] = arrays[j + 1];
                   arrays[j + 1] = temp;
               }
      // System.out.println(arrays);
       System.out.println(Arrays.toString(arrays));
           }
       }
	}


}








