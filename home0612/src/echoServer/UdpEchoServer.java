package echoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.UnknownHostException;

public class UdpEchoServer {
	public static void main(String[] args) {
		new UdpEchoServer().senderUdp();
	}
	public void senderUdp() {
		int myPort = 5001;
		int destPort = 6001;
		String destName = "localhost";
		DatagramSocket ds= null;
		BufferedReader br= null;
		try {
			ds= new DatagramSocket(myPort);
			br= new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("입력>>");
				String sendMsg= br.readLine();
				if(sendMsg.equals("exit")){
					break;
				}
				InetAddress destIp= null;
				try {
					destIp= InetAddress.getByName(destName);
					byte[] byteMsg = sendMsg.getBytes();
					DatagramPacket sendData= new DatagramPacket(byteMsg, byteMsg.length, destIp,destPort);
					ds.send(sendData);
				}catch( UnknownHostException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}
				byte[] byteMsg = new byte[1000];
				DatagramPacket receiveData= new DatagramPacket(byteMsg, byteMsg.length);
				ds.receive(receiveData);
				String receivedStr= new String(receiveData.getData());
				System.out.println("echo메시지 : "+receivedStr);
			}
		}catch(SocketException e) {
			e.printStackTrace();
		}catch( IOException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(br != null) br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(ds != null) ds.close();
		}
	}
}
