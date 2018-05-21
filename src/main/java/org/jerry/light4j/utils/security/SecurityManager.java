package org.jerry.light4j.utils.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jerry.light4j.utils.bytes.ByteUtils;

public class SecurityManager {

	/**
     * ����(��ѡMD5��SHA)
     * @param str
     * @return
     */
    public static String encryptBySHA(String str,String hashType){
    	String result = ""; 
		try {
			//MD5��ʾ�����㷨������ѡ��������������SHA-1��  
			MessageDigest digest = MessageDigest.getInstance(hashType);
			//�ȵ���update���ٵ���digest  
	        digest.update(str.getBytes());  
	        byte[] byteResult = digest.digest();  
	        //��Ϊ������Ϊ�ֽ����飬��Ҫת��Ϊ�ַ���  
	        result = ByteUtils.convertbyte2String(byteResult);  
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
        return result; 
    }
}
