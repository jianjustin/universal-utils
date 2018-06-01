package org.jerry.light4j.utils.bean;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * bean操作集(用于反射进行属性操作,对象clone)
 * @author jian
 *
 */
public class BeanUtils {

	/**
	 * 获取实体内基本属性值
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
	 * 设置实体类属性
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
