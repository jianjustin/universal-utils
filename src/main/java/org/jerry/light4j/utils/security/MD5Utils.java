package org.jerry.light4j.utils.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.jerry.light4j.utils.bytes.ByteUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * MD5������
 * @author jian
 *
 */
public class MD5Utils {
	
	//��Կ������  
    private KeyGenerator kg;   
      
    //�Գ���Կ    
    private SecretKey key;    
      
    //�ӽ���ʱ�ĳ�ʼ������must be 8 bytes long  
    private IvParameterSpec iv;  
      
    //Cipher,�ӽ�������ʵ��  
    private Cipher c;    
    
    public MD5Utils(){
    	init();
    }
    
    /**
     * ��ʼ��key
     */
    public void init(){
    	try {
			kg = KeyGenerator.getInstance("DES","SunJCE");
			kg.init(56);
			key = kg.generateKey();  
	        iv = new IvParameterSpec("12345678".getBytes("UTF-8"));  
	        c = Cipher.getInstance("DES/CBC/PKCS5Padding","SunJCE");//DES�����㷨��CBC�ķ���ģʽ��PKCS5Padding����䷽�� ��SunJCE��Provider  
		} catch (Exception e) {
			e.printStackTrace();
		}    
        
    }
    
    /**
     * ����
     * @param src
     * @return
     */
	public String encrypt(String src){
		String targetString = "";
		try {
			//��ʼ��-- ENCRYPT_MODE������ģʽ�� key����Կ��iv����ʼ������  
	        c.init(Cipher.ENCRYPT_MODE, key, iv);    
	        byte[] srcByte = src.getBytes();    
	        //����  
	        byte[] targetByte = c.doFinal(srcByte);   
	        //Base64����  
	        targetString = new BASE64Encoder().encode(targetByte);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return targetString;
	}
	
	/**  
     * DES����  
     */    
    public String decrypt(String srcString){  
    	byte[] targetByte = null;
    	try {
    		//��ʼ��-- DECRYPT_MODE������ģʽ�� key����Կ��iv����ʼ������  
            c.init(Cipher.DECRYPT_MODE, key, iv);   
            //Base64����  
            byte[] srcByte = new BASE64Decoder().decodeBuffer(srcString);  
            //����  
            targetByte = c.doFinal(srcByte); 
		} catch (Exception e) {
			e.printStackTrace();
		}
           
        return new String(targetByte);    
    } 
    
    /**
     * md5���ܷ���
     * @param str
     * @return
     */
    public String encryptByMD5(String str){
    	String result = ""; 
		try {
			//MD5��ʾ�����㷨������ѡ��������������SHA-1��  
			MessageDigest digest = MessageDigest.getInstance("MD5");
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
    
    /**
     * SHA���ܷ���
     * @param str
     * @return
     */
    public String encryptBySHA(String str){
    	String result = ""; 
		try {
			//MD5��ʾ�����㷨������ѡ��������������SHA-1��  
			MessageDigest digest = MessageDigest.getInstance("SHA");
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
    
    public static void main(String[] args) {
    	String str = "123456";
    	MD5Utils md5Utils = new MD5Utils();
    	String str2 = md5Utils.encrypt(str);
    	System.out.println(str2);
    	String str3 = md5Utils.decrypt(str2);
    	System.out.println(str3);
    	String str4 = md5Utils.encryptByMD5(str);
		System.out.println(str4);
		String str5 = md5Utils.encryptBySHA(str);
		System.out.println(str5);
	}

}
