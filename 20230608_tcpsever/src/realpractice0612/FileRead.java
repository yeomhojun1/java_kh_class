package realpractice0612;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileRead {
	public void readFileB() {
		String path = "D:/data/test";
		String filename= "b.txt";
		new File(path).mkdirs();
		File f2= new File(path, filename);
		FileWriter fw = null;
		try {
			f2.createNewFile();
			fw= new FileWriter(f2);
			fw.write("정말 코딩의 길은 멀고도 험하구나");
			fw.flush();
		}catch(IOException e) {
			System.out.println("파일 생성못함");
			e.printStackTrace();
		}finally {
			try {
				if(fw != null) {
					fw.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void fileRead1() {
		
	
	String filePath= "D:/data/test/b.txt";
	BufferedReader br = null;
	try {
		br= new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
		String str= null;
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.readLine();
	}catch(IOException e) {
		e.printStackTrace();
	}finally {
		try {
			
			if (br != null) br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
}

