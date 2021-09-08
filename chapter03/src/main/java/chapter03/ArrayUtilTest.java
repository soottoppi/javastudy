package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		int[] arr1 = {10, 20, 30, 40};
		double[] arr2 = ArrayUtil.intToDouble(arr1);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}

}
