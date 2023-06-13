package kh.lclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpEchoReceiver {
	public static void main(String[] args) {
		new UdpEchoReceiver().receiverUdp();
	}
	public void receiverUdp() {
		int myPort = 6001;
//		int destPort = 5001;필요가없음 나는 수신받는 용도이기때문에
//		String destName= "localhost"; 얘도 필요없음 받는애라서
		DatagramSocket dSock = null;
		try {
			//DatagramSocket 객체 생성
			dSock = new DatagramSocket(myPort);
			while(true) {
				byte[] byteMsg= new byte[1000];
				DatagramPacket receivedData= new DatagramPacket(byteMsg , byteMsg.length);
				dSock.receive(receivedData);
//				System.out.println("전달받은 정보");
//				
//				System.out.println(byteMsg.length);
//				System.out.println(receivedData.getAddress());
//				System.out.println(receivedData.getPort());
//				System.out.println(receivedData.getData().length);
//				System.out.println(receivedData.getLength());
				String receivedStr = new String(receivedData.getData());
				System.out.println("수신메시지 : "+receivedStr);
				//echo 메시지 송신
//				5. 전송할 메시지를 DatagramPacket 객체에 담음
				DatagramPacket sendData= new DatagramPacket(receivedData.getData() ,receivedData.getLength() ,receivedData.getAddress(), receivedData.getPort());
////			
				dSock.send(sendData);
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
}

