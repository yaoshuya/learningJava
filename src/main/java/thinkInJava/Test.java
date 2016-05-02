package thinkInJava;

import static net.mindview.util.Print.*;

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
		
		public static void main(String[] args)
		{
			Test t1 = new Test(10);
			t1.printMsg();
			Test t2 = new Test(100);
			t2.printMsg();
		}
}
