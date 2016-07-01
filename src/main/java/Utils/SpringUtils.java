package Utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			new String[] { "applicationContext.xml",
					"applicationContext-redis.xml" 
					,"applicationContext-FileIndex.xml"});

	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}
}
