package org.jerry.light4j.utils.json;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * ����json���߼�(����gson)
 * @author jian
 *
 */
public class JsonUtils {
	
	private static Gson gson;
	
	static{
		/*����gson����,���ڲ���gson*/
		if(null ==gson)gson = new Gson();
	}
	
	
	/**
	 * ������ת��δjson�ַ���
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj){
		return gson.toJson(obj);
	}
	
	/**
	 * ����json�ַ�����class����ת��Ϊ��Ӧ����
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
