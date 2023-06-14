package multichat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServerBackground {
	private ServerSocket ss;
	private ServerGUI gui;
	private Map<String, BufferedWriter> mapClients= new HashMap<String, BufferedWriter>();
	private Socket socket;
	private String nickName;
	private int count;
	
	public void setting() {
		Collections.synchronizedMap(mapClients);
		try {
			ss= new ServerSocket(7777);
			while(true) {
				socket= ss.accept();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addClient(String nickname) {
		gui.appendMsg(nickname+"님이 접속했습니다");
		
	}
	public void setNickName(String nickName) {
		this.nickName= nickName;
	}
	public void sendMessage(String msg) {
		Set<String> keys = mapClients.keySet();
		for(String key : keys) {
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
	
}
class Client extends Thread{
	private BufferedReader br;
	private BufferedWriter bw;
	private String nickname;
	public Client(Socket socket) {
		try {
			br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String nickname= br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}