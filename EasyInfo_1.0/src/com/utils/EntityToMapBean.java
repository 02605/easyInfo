package com.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class EntityToMapBean {

	public static Map<Object, Object> object2Map(Object object) {
		Map<Object, Object> result = new HashMap<>();
		// 获得类的的属性名 数组
		Field[] fields = object.getClass().getDeclaredFields();
		try {

			for (Field field : fields) {
				field.setAccessible(true);
				String name = new String(field.getName());
				//------------解析读取出来的奇怪字符串
				if (field.get(object) != null) {
					String dic = (field.get(object).toString());
					if (dic.contains("BaseDict")) {
						int begin = dic.indexOf("item_name=");
						int end = dic.indexOf("]");
						String dic_item = dic.substring(begin + 10, end);
						// System.out.println(dic_item);
						result.put(name, (Object) dic_item);
						continue;
					}
				}
				//-----------
				result.put(name, field.get(object));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
