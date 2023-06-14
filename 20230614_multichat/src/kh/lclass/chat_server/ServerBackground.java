package kh.lclass.chat_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServerBackground {
	private ServerSocket ss;
	private ServerGUI gui;
	
	//client 여러명을 관리 : key: nickname, value:socket객체 
	private Map<String, BufferedWriter> mapClients=new HashMap<String, BufferedWriter>();
//	map.put("socket",socket);
//	map.put("nickname","ej");
	private Socket socket;
	private String nickName;//리스트로 만들어줘야함
	private int count;//현재 접속자 수
	//서버 생성 및 설정
	public void setting() {
		//참고: 동시 접속자로 map에 정보가 동기화되어 들어가도록 설정함.
		Collections.synchronizedMap(mapClients);
		try {
			ss= new ServerSocket(7777);
			while(true) {//방문자 접속을 게속 받아들임. 무한반복함. 
//			GUI프로그램경우 창 닫힐때까지 계속반복됨.break 없음
				//접속자 대기중
				socket = ss.accept();
				//클라이언트 nickname이 바로 이어서 들어옴.
				
				new Client(socket).start();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addClient(String nickname) {
		gui.appendMsg(nickname+"님이 접속했습니다.");
		System.out.println();
	}
	public void removeClient(String nickname) {
		gui.appendMsg(nickname+"님이 나가셨습니다.");
	}

	public void setNickName(String nickName) {
		this.nickName =nickName;
	}
	public void setGui(ServerGUI gui) {
		this.gui=gui;
	}
	

	public void sendMessage(String msg) {
//		client들 모두에게 msg전달
		Set<String> keys= mapClients.keySet();
		for(String key: keys) {
			BufferedWriter wr= mapClients.get(key);
			try {
				wr.write(key+" : "+msg+"\n");
				wr.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendAll(String msg) {
		
	}
	//*********************inner class*********
	class Client extends Thread{
//		private Socket socket;
		private BufferedReader br;//리스트로 만들어줘야함
		private BufferedWriter bw;//리스트로 만들어줘야함
		private String nickname;
		public Client(Socket socket) {
			//초기값설정
			try {
				br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				//접속되면 바로 nickname이 전달될 것이므로 읽음
				nickname= br.readLine();
				//서버 화면에 표현
				addClient(nickname);
				//client outputStream 관리
				mapClients.put(nickname, bw);
//				client map 모두에게 접속정보 전달
				sendMessage(nickname+"님이 접속했습니다."+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			//클라이언트마다 각각에서 전달되어오는 메시지확인
			//client와 입력 통로가 끊어지지 않는다면 계속반복확인함
			//client에서 수신받은 msg,client마다 각각 동작해야해서 새로 클래스를 만들어준거임.
			try {
				while(br!=null) {
					String msg = br.readLine();
					gui.appendMsg(msg);
				}	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					removeClient(nickname);
					sendMessage(nickname+"님이 나갔습니다.");
				}
				
			}
			
			
		}
}

	
	

