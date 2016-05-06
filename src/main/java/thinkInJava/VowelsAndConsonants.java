package thinkInJava;

import java.util.Random;
import static net.mindview.util.Print.*; //static import then I can use printnb not with class Name

public class VowelsAndConsonants {
	public static void main(String[] args)
	{
		Random rand = new Random(47);
		for (int i=0; i<100; i++)
		{
			int c = rand.nextInt(26) +'a';// 0 -- 25
			printnb((char)c + ", " + c + ": ");
			
			switch(c){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u': print("vowel");
			break;
			case 'y':
			case 'w':print("sometimes is vowel");
			break;
			default: print("consonant");
			}
			
		}
	}
}
