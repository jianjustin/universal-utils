package org.jerry.light4j.utils.properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * �������ù��߼�
 * @author jian
 *
 */
public class PropertiesUtils {
	
	/**
	 * ��ȡ�����б�
	 * @param propertiesName
	 * @return
	 */
	public static Properties getProperties(String propertiesName){
		Properties properties = new Properties();
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(PropertiesUtils.class.getClassLoader().getResourceAsStream(propertiesName),"UTF-8");
			properties.load(inputStreamReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	/**
	 * ����������ת����map��ʽ
	 * @param properties
	 * @return
	 */
	public static Map<String,Object> getPropertiesMap(Properties properties){
		Set<Object> keys = properties.keySet();
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		for (Object key : keys) {
			propertiesMap.put(key.toString(), properties.get(key));
		}
		return propertiesMap;
	}

}
