package kh.lclass.io;

public class main {

	public static void main(String[] args) {
		new TestFIleIo().testFile();
		new TestFIleIo().testFileRead();
		new TestFIleIo().testFileRead2();
		try {
			new TestFIleIo().testRamda();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
