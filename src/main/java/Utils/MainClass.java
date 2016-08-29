package Utils;

import static Utils.EncryptionUtil.getMD5;

import java.io.File; 
import java.io.IOException;

public class MainClass {
	public static void main(String[] args) throws IOException {
		File file = new File("/home/student/reference.txt");
 
	    System.out.println(System.getProperty("line.separator").toCharArray());
		System.out.println(getMD5(file));
	}
}
