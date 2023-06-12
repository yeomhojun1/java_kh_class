package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public void testtcpServer(int port) {
//		2. 서버용 소켓 객체 생성
		ServerSocket ss= null;
		Socket sc = null;
		InputStream in= null;
		OutputStream out = null;
		BufferedReader br= null;
		BufferedWriter wr= null;
		try {
			ss= new ServerSocket(port);
			System.out.println(ss.getInetAddress());
			System.out.println(ss.getLocalPort());
			while(true) {
			System.out.println("클라이언트 접속 대기중.... ");
//			3. 클라이언트 쪽에서 접속 요청이 오길 기다림 
//			4.접속 요청이 오면 요청수락후 해당 클라이언트에 대한 소켓 객새 생성
//			아래 코드가 3,4번을 한번에 수행함
			sc=  ss.accept();
			System.out.println("서버(나의) 접속됨:"+sc.getLocalPort());//9001
			System.out.println("클라이언트 접속됨:"+sc.getPort());
			System.out.println("클라이언트 접속됨:"+sc.getInetAddress().toString());
			//5. 연결된 클라이언트와 입출력 스트림 생성
			in = sc.getInputStream();
			out = sc.getOutputStream();
			//6. 보조 스트림을 통해 성능 개선
			 br = new BufferedReader(new InputStreamReader(in));
			wr = new BufferedWriter(new OutputStreamWriter(out));
			String receivedMsg = null;
			while((receivedMsg= br.readLine()) != null) {
			System.out.println("받은 메세지 : "+receivedMsg);
			wr.write("메세지 잘 받았음.\n");
			wr.flush();
			}
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				
				
				
				
				if(br!= null)br.close();
				if(wr!= null)wr.close();
				if(in!= null)in.close();
				if(out!= null)out.close();
				if(sc!= null)sc.close();
				if(ss!= null)ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
