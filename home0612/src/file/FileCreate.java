package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreate {
	public void creatFile() {
		String path= "C:/data/test";
		String filename= "aaa.txt";
		new File(path).mkdirs();
		File f1 = new File(path,filename);
		FileWriter fw = null;
		try {
			f1.createNewFile();
			fw = new FileWriter(f1);
			fw.write("파일생성중");
			fw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(fw != null)
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
