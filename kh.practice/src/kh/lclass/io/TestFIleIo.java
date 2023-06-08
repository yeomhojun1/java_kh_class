package kh.lclass.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TestFIleIo {
	public void testFileOutputStreamObject() {
		Person p1 = new Person("홍길동", 23, "남");
		Person p2 = new Person("김영희", 27, "F");
		String filePath="D:/data2/test/aaa.text";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.flush();
	
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if(oos!= null) oos.close();
				if(fos!= null) fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
			
		
	}
	public void testFileInputStreamObject() {
		String filePath="D:/data2/test/aaa.text";
		FileInputStream ios = null;
		ObjectInputStream ois = null;
		try {
			ios = new FileInputStream(filePath);
			ois = new ObjectInputStream(ios);
			Person a = (Person)(ois.readObject());
			Person b = (Person)(ois.readObject());
			System.out.println(a);
			System.out.println(b);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) ois.close();
				if(ios != null) ios.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	public void testFIleReadData()	{
		String filePath = "D:/data2/test/aaa.text";
		try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))){
			long temp = 0L;
			while((temp= dis.readLong())!= 0) {
				System.out.println(String.valueOf(temp));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void testFIleRead3() {
		String filePath = "D:/data2/test/aaa.text";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (br != null) br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
	public void testRamda() throws UserException{
		int[] arr = { 2, 3, 4 };
		int[] arr2 = new int[] { 2, 3, 4 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		if(arr.length>2	) {
			throw new UserException("배열의 크기는 2보다 크면 안됨");
		}
	}

	public void testFileRead2() {
		String filePath = "D:/data2/test/aaa.text";
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			fis = new FileInputStream(filePath);// 기반,입력스트림
			isr = new InputStreamReader(fis);// 보조스트림
			br = new BufferedReader(isr);// 보조스트림
//			br= new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			// 줄여서 나타내기
			isr = new InputStreamReader(new FileInputStream(filePath));
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			br.readLine();
		} catch (IOException e2) {
			e2.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (isr != null)
					isr.close();
				if (fis != null)
					fis.close();// 해제
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	public void testFileRead() {
		String filePath = "D:/data2/test/aaa.txt";
		FileReader fr = null;
		try {
			fr = new FileReader(filePath);
//				방법 1
//				int a = -1;
//				while((a= fr.read())> -1) {
//					System.out.println((char)a);
//				}
			int cntPerRead = 50;
			char[] readCharArr = new char[600];// char뒤에 공간이 20개 만들어져있음
			for (int i = 0; i < readCharArr.length / 50; i++) {
				int readCnt = fr.read(readCharArr, i*50, cntPerRead);// 가운데숫자는 offset으로 공실임,
//				마지막숫자는 뒤에 들어가는 개수
				System.out.println(readCnt);// 50 : 문자 4개 읽었음
				if (readCnt < 50) {
					break;
				}
			}
			System.out.println(readCharArr);//

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Unhandled exception type IOException
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("==testfIleRead 끝==");
	}

	public void testFile() {
		String path = "D:/data2/test";
		String filename = "aaa.txt";
		new File(path).mkdirs();
		File f2 = new File(path, filename);
		FileWriter fw = null;
		try {
			f2.createNewFile();

			fw = new FileWriter(f2);
			fw.write("한글 한");
			fw.flush();

		} catch (IOException e) {
			System.out.println("file 생성 못함");
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
