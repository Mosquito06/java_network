package java_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
			BufferedReader br = new BufferedReader(new InputStreamReader(opinion.openStream()));
			String line;
			while( (line = br.readLine()) != null){
				System.out.println(line);
			}br.close();
			
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "肋给等 URL 林家");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
