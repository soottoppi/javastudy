package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		String line = "www.douzone.com";
		try {
			InetAddress[] inetAddr = InetAddress.getAllByName(line);
			for(InetAddress i : inetAddr) {
				System.out.println(i);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
