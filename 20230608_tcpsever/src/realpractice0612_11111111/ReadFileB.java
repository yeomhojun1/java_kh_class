package realpractice0612_11111111;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileB {
	public void readB() {
		String path = "D:/data/test";
		String filename= "파일만들기 정복중.txt";
		new File(path).mkdirs();
		File f1= new File(path, filename);
		FileWriter fw = null;
		try {
			f1.createNewFile();
			fw= new FileWriter(f1);
			fw.write("얼추 익숙해지는듯");
			fw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw != null) fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void readB1() {
		String path = "D:/data/test/파일만들기 정복중.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String str = null;
			while((str= br.readLine()) != null) {
				System.out.println(str);
			}
			br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
			}catch ( IOException e) {
				e.printStackTrace();
			}
		}
	}
}
