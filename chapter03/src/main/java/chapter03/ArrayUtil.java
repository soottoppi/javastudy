package chapter03;

public class ArrayUtil {
	public static double[] intToDouble(int[] intArray) {
		double[] doubleArray = new double[intArray.length];
		for(int i=0; i<intArray.length; i++) {
			doubleArray[i] = (double)intArray[i];
		}
		
		return doubleArray;
	}
}
