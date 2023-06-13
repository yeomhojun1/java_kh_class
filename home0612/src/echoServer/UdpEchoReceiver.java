package echoServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoReceiver {
	public static void main(String[] args) {
		
	}
	public void receiver() {
		int myPort= 6001;
		DatagramSocket ds= null;
		try {
			ds= new DatagramSocket(myPort);
			while(true) {
				byte[] byteMsg = new byte[1000];
				DatagramPacket receivedData= new DatagramPacket(byteMsg, byteMsg.length);
				ds.receive(receivedData);
				String receivedStr = new String(receivedData.getData());
				System.out.println("수신메시지 : "+receivedStr);
				DatagramPacket sendData = new DatagramPacket(receivedData.getData(), receivedData.getLength(), receivedData.getAddress(), receivedData.getPort());
				ds.send(sendData);
				
			}
		}catch(SocketException e	) {
			e.printStackTrace();
		}catch(IOException e)	{
			e.printStackTrace();
		}
	}
}

