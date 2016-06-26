package ch4;

import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.beans.BeanMap;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import Models.Student;

public class CglibTest2 {

	//map2bean use cglib 
	private <T> T generateBean(Map<String, Object> propertyMap,Class<T> beanClass) throws InstantiationException, IllegalAccessException {
		//use this method, the class must has get and setter method
		BeanMap bm = BeanMap.create(beanClass.newInstance());
 		bm.putAll(propertyMap);
		return beanClass.cast(bm.getBean());
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		CglibTest2 test2 = new CglibTest2();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("age", 20);
		map.put("name", "student");
		
		Student st = test2.generateBean(map, Student.class);
		System.out.println(ReflectionToStringBuilder.toString(st,ToStringStyle.MULTI_LINE_STYLE));
		
	}

}
