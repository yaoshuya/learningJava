package thinkInJava;
import static net.mindview.util.Print.*;
public class BasicTypeDemo {

	public static void stringdemo()
	{
		String str1 = "abc"; //stored in consant pool?
		String str2 = new String("abc"); // two objects one in stack one in heap
		print("\"abc\" compare with new String(\"abc\")" + str1==str2);
		String str3 = "abc";
		print(" two string constant \"abc\" compare is " + str3==str1);
		String str4 = "ab" + "c";
		print("\"abc\" compare with \"ab\" + \"c\" " + str3==str4);
		
		String str5 = new StringBuilder().append("a").append("bc").toString();
		print(str5.intern()==str2.intern());
		System.out.println(str3.equals(str4) + " string content compare use equals method , same content is same, return true");
		print("abc".equalsIgnoreCase("ABC"));
		for(byte b : "abc".getBytes())
			printnb(b + "\n");
		
		String s1 = new String("abc");
		String s2 = s1.intern(); 
		print("new String(abc) compare with its own intern() is " + s1==s2);
		 
	}
	
	public static void strinbBufferDemo()
	{
		StringBuffer sb = new StringBuffer();
		//append delete update replace search
		sb.append("abc");
		sb.delete(1, 2);
		print("abc delete 1,2 then become is " + sb.toString());
		sb.insert(1,"b");
		print("ac insert 1,b is " + sb.toString());
		print("sb revere is " + sb.reverse());
		print("stringbuffer and stringbuilder is most same, the former is thread synchronized \n"
				+ "can use multiple threads case, the later is used in single thread case.");
	}
	
	public static void basicTypeDemo()
	{
		Integer i = Integer.valueOf("5");
		Double  d = Double.valueOf("100.20");
		Float f = Float.valueOf("100.2222");
		
		print(i.toString());
		print(d);
		print(f);
		print(Integer.toBinaryString(i));
		print(Integer.toHexString(i));
		print(Integer.toOctalString(i));
		
		Double dd = new Double(0.0/0.0);
		print(dd.isNaN());
		
	}
	
	public static void main(String[] args) {
		//stringdemo();	
		//strinbBufferDemo();
		//basicTypeDemo();
		
	}

	
} 
