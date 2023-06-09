package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	public void testTcpClient(String ip, int port) {
		//1. 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
		Socket socket = null;
		InputStream in= null;
		OutputStream out = null;
		BufferedReader br= null;
		PrintWriter pr= null;

		
		//console에 입력한 문자를 읽어들이기 위한 객체 2가지
		//Scanner와 유사한 기능
//		Scanner scn = new Scanner(System.in);
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
//		
		try {
			socket = new Socket(ip, port);
			System.out.println("서버에 접속성공");
			//5. 연결된 클라이언트와 입출력 스트림 생성
			in = socket.getInputStream();
			out = socket.getOutputStream();
			//6. 보조 스트림을 통해 성능 개선
			br = new BufferedReader(new InputStreamReader(in));
			pr = new PrintWriter(new OutputStreamWriter(out));
			
			String sendMsg= null;
			System.out.print("메세지>>");
			sendMsg = stdIn.readLine();//console에 입력한 문자를 읽어들이기
			pr.println(sendMsg);
			pr.flush();
			
			String receivedMsg= br.readLine();
			System.out.println("서버로부터 받은 메세지 : "+receivedMsg);
			pr.write("서비스 잘 부탁드립니다");
			pr.flush();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(stdIn != null)stdIn.close();
				if(br!= null)br.close();
				if(pr!= null)pr.close();
				if(in!= null)in.close();
				if(out!= null)out.close();
				if(socket != null)socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
	}
}
