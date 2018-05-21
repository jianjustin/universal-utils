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
 * MD5工具类
 * @author jian
 *
 */
public class MD5Utils {
	
	//密钥生成器  
    private KeyGenerator kg;   
      
    //对称密钥    
    private SecretKey key;    
      
    //加解密时的初始化向量must be 8 bytes long  
    private IvParameterSpec iv;  
      
    //Cipher,加解密主体实例  
    private Cipher c;    
    
    public MD5Utils(){
    	init();
    }
    
    /**
     * 初始化key
     */
    public void init(){
    	try {
			kg = KeyGenerator.getInstance("DES","SunJCE");
			kg.init(56);
			key = kg.generateKey();  
	        iv = new IvParameterSpec("12345678".getBytes("UTF-8"));  
	        c = Cipher.getInstance("DES/CBC/PKCS5Padding","SunJCE");//DES加密算法，CBC的反馈模式，PKCS5Padding的填充方案 ，SunJCE：Provider  
		} catch (Exception e) {
			e.printStackTrace();
		}    
        
    }
    
    /**
     * 加密
     * @param src
     * @return
     */
	public String encrypt(String src){
		String targetString = "";
		try {
			//初始化-- ENCRYPT_MODE：加密模式， key：密钥，iv：初始化向量  
	        c.init(Cipher.ENCRYPT_MODE, key, iv);    
	        byte[] srcByte = src.getBytes();    
	        //加密  
	        byte[] targetByte = c.doFinal(srcByte);   
	        //Base64编码  
	        targetString = new BASE64Encoder().encode(targetByte);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return targetString;
	}
	
	/**  
     * DES解密  
     */    
    public String decrypt(String srcString){  
    	byte[] targetByte = null;
    	try {
    		//初始化-- DECRYPT_MODE：解密模式， key：密钥，iv：初始化向量  
            c.init(Cipher.DECRYPT_MODE, key, iv);   
            //Base64解码  
            byte[] srcByte = new BASE64Decoder().decodeBuffer(srcString);  
            //解密  
            targetByte = c.doFinal(srcByte); 
		} catch (Exception e) {
			e.printStackTrace();
		}
           
        return new String(targetByte);    
    } 
    
    /**
     * md5加密方法
     * @param str
     * @return
     */
    public String encryptByMD5(String str){
    	String result = ""; 
		try {
			//MD5表示加密算法，可以选择其他参数，如SHA-1等  
			MessageDigest digest = MessageDigest.getInstance("MD5");
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
    
    /**
     * SHA加密方法
     * @param str
     * @return
     */
    public String encryptBySHA(String str){
    	String result = ""; 
		try {
			//MD5表示加密算法，可以选择其他参数，如SHA-1等  
			MessageDigest digest = MessageDigest.getInstance("SHA");
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
