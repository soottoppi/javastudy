package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		double[] a1 = ArrayUtil.intToDouble(new int[] {10, 20, 30, 40, 50});
		System.out.println(Arrays.toString(a1));
		
		int[] a2 = ArrayUtil.doubleToInt(new double[] {10.1, 20.2, 30.3, 40.4, 50.5});
		System.out.println(Arrays.toString(a2));
		
		int[] a3 = ArrayUtil.concat(new int[] {1,2,3,4}, new int[] {5,6,7,8});
		System.out.println(Arrays.toString(a3));
	}

}
