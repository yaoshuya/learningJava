package realWorldJava;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import redisDemo.RedisClient;
 

public class TestJson {
	 
	
	public static void main(String[] args) throws IOException {
	final String filepath ="/home/student/git/learningJava/src/main/resources/jsons.txt";
	String str = FileUtils.readFileToString(new File(filepath ),"UTF-8");
	//System.out.println(str);
	AlarmMsgEntity entity = JsonUtil.getInstance().json2obj(str, AlarmMsgEntity.class);
	System.out.println(ReflectionToStringBuilder.toString(entity,ToStringStyle.MULTI_LINE_STYLE));
	
	
	Map<String,String> hm = new HashMap<String,String>();
	hm.put("key1", "value1");
	hm.put("key2","value2");
	hm.put("key3", "value3");
	hm.put("key4","value4");  

	RedisClient.jedisCluster.hmset("hm", hm);
	
  }
}
