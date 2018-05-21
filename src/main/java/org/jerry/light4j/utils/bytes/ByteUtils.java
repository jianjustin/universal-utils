package org.jerry.light4j.utils.bytes;

public class ByteUtils {

	//���ֽ�����ת��Ϊ�ַ���  
	public static String convertbyte2String(byte[] byteResult)   
	{  
	    char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };  
	      
	    //4λ����һ��16���ƣ����Գ�����Ҫ��Ϊԭ��2��  
	    char[] result = new char[byteResult.length*2];  
	      
	    int index = 0;  
	    for(byte b:byteResult)  
	    {  
	        //��ת����4λ  
	        result[index++] = hexDigits[(b>>>4)& 0xf];  
	        result[index++] = hexDigits[b& 0xf];  
	    }  
	    return new String(result);  
	}  
}
