package org.jerry.light4j.utils.json;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * 创建json工具集(基于gson)
 * @author jian
 *
 */
public class JsonUtils {
	
	private static Gson gson;
	
	static{
		/*创建gson对象,用于操作gson*/
		if(null ==gson)gson = new Gson();
	}
	
	
	/**
	 * 将对象转换未json字符串
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj){
		return gson.toJson(obj);
	}
	
	/**
	 * 根据json字符串和class对象转化为相应对象
	 * @param str
	 * @param clazz
	 * @return
	 */
	public static <T> T fromJson(String str, Class<T> clazz){
		return gson.fromJson(str, clazz);
	}
	
	public static Gson getGson() {
		return gson;
	}
	public static void setGson(Gson gson) {
		JsonUtils.gson = gson;
	}
	
	public static void main(String[] args) {
		String str = "{\"abc\":\"11\",\"abcd\":1,\"abcde\":\"ddd\",\"aa\":[11,12,13]}";
		Map<String,Object> map = gson.fromJson(str, HashMap.class);
		System.out.println(map);
	}

}
