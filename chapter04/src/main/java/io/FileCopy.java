package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileCopy {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("siamese.jpg");
			is.read();
		} catch (FileNotFoundException e) {
			System.out.println("file not found : " + e);
		} finally {
			try {
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
