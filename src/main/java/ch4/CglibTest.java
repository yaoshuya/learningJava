package ch4;

import java.lang.reflect.Method;
import java.util.HashMap;

public class CglibTest {
	
	public static void main(String[] args) throws ClassNotFoundException {
 
	 // 设置类成员属性
    HashMap<String, Class<?>> propertyMap = new HashMap<String, Class<?>>();
    propertyMap.put("id", Class.forName("java.lang.Integer"));
    propertyMap.put("name", Class.forName("java.lang.String")); 
    propertyMap.put("address", Class.forName("java.lang.String"));

    // 生成动态 Bean
    CglibBean bean = new CglibBean(propertyMap);

    // 给 Bean 设置值
    bean.setValue("id", new Integer(123)); 
    bean.setValue("name", "454"); 
    bean.setValue("address", "789");
 
    System.out.println("  >> id      = " + bean.getValue("id")); 
    System.out.println("  >> name    = " + bean.getValue("name")); 
    System.out.println("  >> address = " + bean.getValue("address"));
 
    Object object = bean.getObject();
 
    Class<? extends Object> clazz = object.getClass();
    Method[] methods = clazz.getDeclaredMethods();
    for (int i = 0; i < methods.length; i++) {
        System.out.println(methods[i].getName());
    }
    
	}
}
