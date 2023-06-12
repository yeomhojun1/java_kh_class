package realpractice0612;

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

public class ClientPractice {
	public void testClient(String ip, int port){
	Socket sc= null;
	InputStream in = null;
	OutputStream out = null;
	BufferedReader br= null;
	PrintWriter pr = null;
	BufferedReader stdIn= new BufferedReader(new InputStreamReader(System.in));
	try {
		sc = new Socket(ip, port);
		in = sc.getInputStream();
		out = sc.getOutputStream();
		br = new BufferedReader(new InputStreamReader(in));
		pr= new PrintWriter(new OutputStreamWriter(out));
		String sendMsg= null;
		while(true) {
			sendMsg= stdIn.readLine();
			pr.println();
			pr.flush();
			String receivedMsg= br.readLine();
		}
	}catch(UnknownHostException e	) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}finally {
		try {
			if(stdIn != null) stdIn.close();
			if(pr != null) pr.close();
			if(br != null) br.close();
			if(out != null) out.close();
			if(in != null) in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	}
}
