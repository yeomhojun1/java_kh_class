package realpractice0612;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPractice {
	public void testServer(int port) {
		ServerSocket ss = null;
		Socket sc = null;
		InputStream in=null;
		OutputStream out= null;
		BufferedReader br= null;
		BufferedWriter wr = null;
		try {
			ss = new ServerSocket(port);
			while(true) {
				sc= ss.accept();
				in = sc.getInputStream();
				out = sc.getOutputStream();
				br= new BufferedReader(new InputStreamReader(in));
				wr= new BufferedWriter(new OutputStreamWriter(out));
				String receivedMsg = null;
				while((receivedMsg= br.readLine()) != null) {
					wr.write("sadfas");
					wr.flush();
					
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(wr != null) wr.close();
				if(br != null) br.close();
				if(out != null) out.close();
				if(in != null) in.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
