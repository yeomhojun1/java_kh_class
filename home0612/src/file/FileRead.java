package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileRead {
	public void readFile() {
		String path = "C:/data/test/aaa.txt";
		BufferedReader br = null;
		try {
			br=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String str = null;
			while((str= br.readLine())!= null) {
				System.out.println(str);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
