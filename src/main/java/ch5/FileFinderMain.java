package ch5;

import java.io.IOException;

import Utils.SpringUtils;

public class FileFinderMain {

	public static void main(String[] args) throws IOException {
		FileIndexTask myFileIndex = (FileIndexTask) SpringUtils
				.getBean("myFileIndex");
		myFileIndex.run();
		CliHandler clihandler = (CliHandler) SpringUtils
				.getBean("myCliHandler");
		clihandler.handleCmd();
	}

}
