package ch12;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.data.redis.core.RedisTemplate;

 
public class FileIndexTask implements Runnable {

	public FileIndexTask() {

	}

	private File dir;

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}

	public void setDir(String dir){
		this.dir = new File(dir);
	}
	
	private String[] extensions = { "txt","log" };

	@Resource
	private RedisTemplate<String, String> jedisTemplate;

	private String indexFile;

	public void setIndexFile(String _indexfile){
		this.indexFile = _indexfile ;
	}
	@Override
	public void run() {
		System.out.println(dir.getAbsolutePath());
		List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
		System.out.println("find files:" + files.size());
		StringBuilder sb = new StringBuilder();
		for (File file : files) {
			try {
				String fileCont = FileUtils.readFileToString(file,Charset.forName("UTF-8")).replace("`", "").replaceAll("\r|\n"," ");
				sb.append(file.getName() + "`" + file.getAbsolutePath() + "`" + 
			    fileCont + "\n");
				System.out.println(file.getName() + ":" + fileCont);
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
		try {
			FileUtils.writeStringToFile(new File(indexFile),
					sb.toString(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
