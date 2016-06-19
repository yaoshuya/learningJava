package thinkInJava;

import java.util.Hashtable;
import java.util.Map.Entry;

public class CollectionDemo {
	public static void main(String[] args) {
		Hashtable<String,String> ht = new Hashtable<String,String>();
		ht.put("1","1");
		ht.put("2","2");
		ht.put("3","3");
		ht.put("4","4");
		for(Entry<String, String> entry : ht.entrySet())
			System.out.println(entry.getKey() + "  " + entry.getValue());
		
		 
	}
}
