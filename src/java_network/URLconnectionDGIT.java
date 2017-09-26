package java_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class URLconnectionDGIT {

	public static void main(String[] args) {
		try {
			URL dgit = new URL("http://dgit.or.kr/login.php");
			URLConnection uc = dgit.openConnection();
			
			uc.setDoOutput(true);
			OutputStreamWriter osw = new OutputStreamWriter(uc.getOutputStream());
			osw.write("user_id=아이디 & userpasswd=비밀번호");
			osw.close();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String line;
			
			while((line = br.readLine())!= null){
				System.out.println(line);
			}br.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
