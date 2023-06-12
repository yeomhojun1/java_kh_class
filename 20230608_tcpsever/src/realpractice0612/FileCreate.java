package realpractice0612;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreate {
	public void helloWorld() {
		String path = "D:/data2/test";
		String filename= "a.txt";
		new File(path).mkdirs();
		File f2= new File(path, filename);
		FileWriter fw = null;
		try {
			f2.createNewFile();
			fw= new FileWriter(f2);
			fw.write("hello world");
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
}
