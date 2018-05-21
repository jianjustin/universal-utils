package org.jerry.light4j.utils.bytes;

public class ByteUtils {

	//将字节数组转化为字符串  
	public static String convertbyte2String(byte[] byteResult)   
	{  
	    char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };  
	      
	    //4位代表一个16进制，所以长度需要变为原来2倍  
	    char[] result = new char[byteResult.length*2];  
	      
	    int index = 0;  
	    for(byte b:byteResult)  
	    {  
	        //先转换高4位  
	        result[index++] = hexDigits[(b>>>4)& 0xf];  
	        result[index++] = hexDigits[b& 0xf];  
	    }  
	    return new String(result);  
	}  
}
