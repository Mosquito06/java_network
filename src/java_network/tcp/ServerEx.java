package java_network.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {

	public static void main(String[] args) {
		BufferedReader in = null; // Ŭ���̾�Ʈ�� ���� ���� �޽����� �б����� Reader
		BufferedReader stIn = null; // Ű����� ���� �Է¹ޱ� ���� Reader
		BufferedWriter out = null; // Ŭ���̾�Ʈ�� ���� Writer

		ServerSocket listener = null; // ���� ����(Ŭ���̾�Ʈ�� ��û�� ����ϴ� ����)
		Socket socket = null; // Ŭ���̾�Ʈ�� �ְ���� ����

		try {
			listener = new ServerSocket(9999); //
			System.out.println("Server Ready~~!!");
			socket = listener.accept();
			System.out.println("Ŭ���̾�Ʈ��  ����Ǿ����ϴ�.");

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stIn = new BufferedReader(new InputStreamReader(System.in));

			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			String clientMsg;
			while (true) {
				clientMsg = in.readLine();
				if (clientMsg.equalsIgnoreCase("bye")) {
					break;
				}
				System.out.println(clientMsg);
				String outputMsg = stIn.readLine();
				out.write(" ���� >" + outputMsg);
				out.flush();
			}

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				socket.close();
				listener.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
