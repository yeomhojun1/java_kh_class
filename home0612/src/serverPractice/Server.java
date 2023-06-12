package serverPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void server1(int port) {
		ServerSocket ss= null;
		Socket sc = null;
		InputStream in =  null;
		OutputStream out = null;
		BufferedReader br = null;
		BufferedWriter wr = null;
		try {
			ss= new ServerSocket(port);
			System.out.println(ss.getInetAddress());
			System.out.println(ss.getLocalPort());
			System.out.println("클라이언트 접속 대기중...");
			sc=  ss.accept();
			System.out.println("서버(나의) 접속됨 "+sc.getLocalPort());
			while(true) {
				in = sc.getInputStream();
				out = sc.getOutputStream();
				br = new BufferedReader(new InputStreamReader(in));
				wr = new BufferedWriter(new OutputStreamWriter(out));
				String receivedMsg = null;
					while((receivedMsg= br.readLine()) != null) {
						System.out.println("받은 메세지 :"+receivedMsg);
						wr.write("공부열심히하자");
						wr.flush();
					}
			}
		}catch(IOException e ) {
			e.printStackTrace();
		}finally {
				try {
					if(wr != null) wr.close();
					if(br != null) br.close();
					if(out != null) out.close();
					if(in != null) in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
}
