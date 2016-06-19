package thinkInJava;

import static net.mindview.util.Print.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;
 

@SuppressWarnings("unused")
public class Test {
		private static int i;
		static private int counter;
		
		public Test(int _i)
		{
			i = _i;	
			counter++;
		}
		
		public void printMsg()
		{    
			print(i);
			print("total number of class Test is " + counter);
		}
		public static Properties getProperty(String filepath,Integer method) throws IOException
		{
			Properties p = new Properties();
			if(method.equals(1))
			{	
				InputStream is =Test.class.getResourceAsStream(filepath);			
				//InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath);
				p.load(is);
			}
			else
				{
					FileInputStream fis = new FileInputStream(new File(filepath));
					p.load(fis);
				}
			print(p.get("key2"));
			return p;
		}
		
		public static void main(String[] args) throws IOException
		{
		 String abc = "I am a java programer";
		 print(abc.hashCode());
		 
		}
}
