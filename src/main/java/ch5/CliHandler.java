package ch5;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class CliHandler {
	
	private String dir ;
	public void setDir(String _dir){
		this.dir = _dir;
	}
	
	private void filterKeyword(List<String> fileList, String keyword){
		for(String file:fileList)
			if(file.contains(keyword)) System.out.println(file);
	}
	
	//accept user input and then filter the index file then output the filename
	public void handleCmd() throws IOException
	{
		List<String> fileList = FileUtils.readLines(new File(dir),"UTF-8");
		for(String file:fileList)
			System.out.println(file);
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please input the keyword you want to search:");
		String keyword = bfr.readLine();
		while(!keyword.equals("exit")){
			//print keyword in the filename
			filterKeyword(fileList,keyword);
			System.out.println("Please input the keyword you want to search:");
			keyword = bfr.readLine();
		}
	}
}
