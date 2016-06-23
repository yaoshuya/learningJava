package redisDemo;

import java.net.MalformedURLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;

public class ReidsExample {
 
	public static void main(String[] args) throws MalformedURLException {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("applicationContext-redis.xml")
						.getPath());
		@SuppressWarnings("unchecked")
		RedisTemplate<String, String>  jedisTemplate = (RedisTemplate<String, String>) context.getBean("jedisTemplate");
		jedisTemplate.opsForValue().set("jedis_test","hello world");
		
	}
}
