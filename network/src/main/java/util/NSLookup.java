package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		String line = "www.google.com";
		try {
			InetAddress[] inetAddr = InetAddress.getAllByName(line);
			String hostName = null;
			String addresses = null;
			for (InetAddress i : inetAddr) {
				hostName = i.getHostName();
				addresses = i.getHostAddress();

				System.out.println("서버 : " + hostName);
				System.out.print("Address : ");
				System.out.println(addresses);
//				int count = 0;
//				for (byte address : addresses) {
//					System.out.print(address & 0x000000ff); // 4bytes = 8bits * 4 = 32bits
//					if (count != 3) {
//						System.out.print('.');
//					}
//					count++;
//
//				}
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
