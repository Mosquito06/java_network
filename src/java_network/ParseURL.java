package java_network;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class ParseURL {

	public static void main(String[] args) {
		URL opinion = null;
		URL homePage = null;
		
		//http://dgit.or.kr/SUB/?ctId=15
		
		try {
			homePage = new URL("http://dgit.or.kr:80");
			opinion = new URL(homePage, "/SUB/?ctId=15");
			System.out.printf("protocal : %s%n", opinion.getProtocol());
			System.out.printf("host : %s%n", opinion.getHost());
			System.out.printf("port : %s%n", opinion.getPort());
			System.out.printf("path : %s%n", opinion.getPath());
			System.out.printf("filename : %s", opinion.getFile());
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "肋给等 URL 林家");
		}

	}

}
