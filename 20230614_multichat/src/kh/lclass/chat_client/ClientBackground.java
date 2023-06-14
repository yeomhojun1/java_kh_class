package kh.lclass.chat_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientBackground {
	private Socket socket;//필드는 따로 close안해도됨, 가비지 컬렉션에의해 close됨
	private BufferedReader br;
	private BufferedWriter bw;
	private String nickName;
	private ClientGUI gui;//null//new를 하면 안됨, 계속 무한루프
	
	
	//client가 서버와 접속끊기
	public void disconnection() {
			try {
				if(socket!= null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	//client가 서버에 접속
	public void connection() {
		try {
			//서버와 연결
			socket = new Socket("127.0.0.1", 7777);
			//서버와 입/출력 통로 생성
			br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//접속되면 바로 나의 nickname 전송
			bw.write(nickName+"\n");
			bw.flush();
			//server와 입력(br)통로가 끊어지지 않는다면 계속 반복확인함.
//			server에서 수신받은 msg
			while(br != null) {
				String msg = br.readLine();
				gui.appendMsg(msg);
				
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendMessage(String msg) {
		//서버에 msg전달
		try {
			bw.write(nickName+" : "+msg+"\n");
			bw.flush();
			gui.appendMsg(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}
}
