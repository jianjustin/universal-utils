package org.jerry.light4j.utils.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jerry.light4j.utils.bytes.ByteUtils;

public class SecurityManager {

	/**
     * 加密(可选MD5或SHA)
     * @param str
     * @return
     */
    public static String encryptBySHA(String str,String hashType){
    	String result = ""; 
		try {
			//MD5表示加密算法，可以选择其他参数，如SHA-1等  
			MessageDigest digest = MessageDigest.getInstance(hashType);
			//先调用update，再调动digest  
	        digest.update(str.getBytes());  
	        byte[] byteResult = digest.digest();  
	        //因为加密完为字节数组，需要转化为字符串  
	        result = ByteUtils.convertbyte2String(byteResult);  
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
        return result; 
    }
}
