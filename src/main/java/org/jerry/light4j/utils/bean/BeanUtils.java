package org.jerry.light4j.utils.bean;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * bean工具集
 * @author jian
 *
 */
public class BeanUtils {

	/**
	 * 属性获取
	 * @param obj
	 * @param propertyName
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T> Object getPropertyByName(T obj,String propertyName) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return PropertyUtils.getProperty(obj, propertyName);
	}
	
	/**
	 * 属性设置
	 * @param obj
	 * @param propertyName
	 * @param propertyValue
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T> void setPropertyByName(T obj,String propertyName,Object propertyValue) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		PropertyUtils.setProperty(obj, propertyName, propertyValue);
	}
	
}
