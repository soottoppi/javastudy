package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		String resultString = "";
		for(String str : strArr) {
			resultString += str;
		}
		return resultString;
	}
	
}
