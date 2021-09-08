package chapter03;

import java.util.stream.IntStream;

public class ArrayUtil {
	public static double[] intToDouble(int[] intArray) {
		double[] doubleArray = new double[intArray.length];
		for(int i=0; i<intArray.length; i++) {
			doubleArray[i] = (double)intArray[i];
		}
		
		return doubleArray;
	}

	public static int[] doubleToInt(double[] doubleArray) {
		int[] intArray = new int[doubleArray.length];
		for(int i=0; i<doubleArray.length; i++) {
			intArray[i] = (int)doubleArray[i];
		}
		return intArray;
	}

	public static int[] concat(int[] arr1, int[] arr2) {
		int[] arr3 = IntStream.concat(IntStream.of(arr1), IntStream.of(arr2)).toArray();
		return arr3;
	}
}
