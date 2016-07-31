package ch9.fileviewer;

import java.io.Serializable;

public class FileEntity2 implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	private String file_name;
	private String file_path;

	public FileEntity2(){}
	
	public FileEntity2(String name, String absolutePath) {
	 	 this.file_name = name;
		 this.file_path = absolutePath;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

 
}
