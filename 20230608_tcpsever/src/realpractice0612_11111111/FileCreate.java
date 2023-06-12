package realpractice0612_11111111;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreate {
	public void createAfile() {
		String path = "D:/data/test";
		String filename= "코딩연습.txt";
		new File(path).mkdirs();
		File coding = new File(path, filename);
		FileWriter fw= null;
		try {
			coding.createNewFile();
			fw= new FileWriter(coding);
			fw.write("코딩연습11");
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
}
