package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			
			
			System.out.println(hostName);
			System.out.println(hostAddress);
			
			byte[] addresses = inetAddress.getAddress();
			for(byte adress : addresses) {
				System.out.print(adress & 0x000000ff);	// 4bytes = 8bits * 4 = 32bits
				System.out.print('.');
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
