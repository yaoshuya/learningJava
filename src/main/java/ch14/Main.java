package ch14;

public class Main {
	public static void main(String[] args) {
		   String str = "bb:oo:and:foo";
	        String[] strArray = str.split("o");
	        for(String item:strArray){
	        	System.out.println(item);
	        }
	}
}
