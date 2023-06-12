package serverPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public void client1(String ip, int port) {
		Socket sc= null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br= null;
		PrintWriter pw = null;
		BufferedReader stdIn= new BufferedReader(new InputStreamReader(System.in));
		try {
			sc= new Socket(ip, port);
			System.out.println("서버에 접속성공");
			in= sc.getInputStream();
			out= sc.getOutputStream();
			br = new BufferedReader(new InputStreamReader(in));
			pw = new PrintWriter(new OutputStreamWriter(out));
			String sendMsg= null;
			while(true) {
				System.out.println("메세지>>");
				sendMsg = stdIn.readLine();
				pw.println(sendMsg);
				pw.flush();
				String receivedMsg = br.readLine();
				System.out.println("서버로부터 받은 메세지 "+receivedMsg);
				pw.write("서비스 잘 부탁드립니다");
				pw.flush();
			}
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
				try {
					if(pw != null) pw.close();
					if(br != null) br.close();
					if(pw != null) pw.close();
					if(pw != null) pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
	}
       }
