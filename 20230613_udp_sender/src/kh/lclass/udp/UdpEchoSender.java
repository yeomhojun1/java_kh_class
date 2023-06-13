package kh.lclass.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpEchoSender {
	public static void main(String[] args) {
		new UdpEchoSender().senderUdp();
	}
	public void senderUdp() {
		//포트번호 정함
		int myPort = 5001;
		int destPort= 6001;
		String destName= "localhost";
		DatagramSocket dSock = null;
		BufferedReader br = null;
		try {
		
			//DatagramSocket 객체 생성
			dSock = new DatagramSocket(myPort);
			br = new BufferedReader(new InputStreamReader(System.in));
			//매개인자 없으면 자동 port번호 할당
//			매개인자 지정하면 해당 포트 번호로 소켓 생성
			while(true) {
				System.out.println("입력>>");
				String sendMsg = br.readLine();//console입력받음
				if(sendMsg.equals("exit")) {
					break;
				}
			//전달할 메시지
				InetAddress destIp=null;
				try {
//			3. 연결한 클라이언트 ip주소를 가진 inetaddress객체 생성
					destIp = InetAddress.getByName("localhost");
//			4.전송할 메시지를 byte[]로 바꿈
					byte[] byteMsg = sendMsg.getBytes();
//			5. 전송할 메시지를 DatagramPacket 객체에 담음
					DatagramPacket sendData= new DatagramPacket(byteMsg , byteMsg.length ,destIp, destPort);
//			6. 소켓 레퍼런스를 사용해서 메시지 전송
					dSock.send(sendData);
				}catch(UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				byte[] byteMsg= new byte[1000];
				DatagramPacket receiveData= new DatagramPacket(byteMsg , byteMsg.length);
				dSock.receive(receiveData);
				String receiverdStr= new String(receiveData.getData());
				System.out.println("Echo메시지 :"+ receiverdStr);
				}
		}catch (SocketException e)	{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(br != null) br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(dSock != null) dSock.close();
		}
		
		
	}
}
