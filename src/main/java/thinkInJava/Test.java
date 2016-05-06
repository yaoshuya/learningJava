package thinkInJava;

import static net.mindview.util.Print.*;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
 

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
		
		public static void main(String[] args) throws IOException
		{
			//Runtime r = Runtime.getRuntime();
			//Process p = r.exec("notepad.exe abc.txt");
			//p.destroy();
			Properties prop = System.getProperties();
			for(Entry<?, ?> item :prop.entrySet())
				print(item.getKey() + " : " + item.getValue());
		}
}
