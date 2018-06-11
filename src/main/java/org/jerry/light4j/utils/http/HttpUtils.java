package org.jerry.light4j.utils.http;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * http工具集合
 * @author admin
 *
 */
public class HttpUtils {
	
	/** 
     * post方式提交json代码 
	 * @return 
     * @throws Exception  
     */  
    public static String postJson(String url,String paramValue) throws Exception{  
        CloseableHttpClient httpclient = null;  
        CloseableHttpResponse response = null;  
        String result = "";
        try {  
            httpclient = HttpClients.createDefault();    
            HttpPost httpPost = new HttpPost(url);  
            httpPost.addHeader(HTTP.CONTENT_TYPE,"application/x-www-form-urlencoded");  
            //参数  
            StringEntity se = new StringEntity(paramValue);  
            se.setContentEncoding("UTF-8");  
            se.setContentType("application/json");//发送json需要设置contentType  
            httpPost.setEntity(se);  
            response = httpclient.execute(httpPost);  
            //解析返结果  
            HttpEntity entity = response.getEntity();   
            if(entity != null){  
            	result = EntityUtils.toString(entity, "UTF-8");      
            }  
        } catch (Exception e) {  
            throw e;  
        }finally{  
            httpclient.close();  
            response.close();  
        }  
        return result;
    }  
      
     /**  
     * post方式提交表单（模拟用户登录请求）  
     * @return 
     * @throws Exception  
     */    
    public static String postForm(String url,Map<String,Object> paramValue) throws Exception  {  
    	List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        CloseableHttpClient httpclient = null;  
        CloseableHttpResponse response = null;  
        String result = "";
        try {  
            httpclient = HttpClients.createDefault();    
            HttpPost httppost = new HttpPost(url);    
            // 创建参数队列      
            Set<String> keySet = paramValue.keySet();
            for (String key : keySet) {
            	Object value = paramValue.get(key);
            	if(null == value)value = "";
            	formparams.add(new BasicNameValuePair(key, value.toString()));
			}
            //参数转码  
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");    
            httppost.setEntity(uefEntity);   
            response = httpclient.execute(httppost);    
            HttpEntity entity = response.getEntity();    
            if (entity != null) {    
            	result = EntityUtils.toString(entity,"UTF-8");//响应实体
            }    
            //释放连接  
        } catch (Exception e) {  
            throw e;  
        }finally{  
             httpclient.close();  
             response.close();  
        }  
        return result;
    }    
      
    /**  
     * 发送 get请求  
     * @throws Exception  
     */    
    public static String get() throws Exception {    
        CloseableHttpClient httpclient = null;  
        CloseableHttpResponse response = null;
        String result = "";
        try {  
            httpclient = HttpClients.createDefault();    
            HttpGet httpget = new HttpGet("http://www.baidu.com/");    
            response = httpclient.execute(httpget);    
            HttpEntity entity = response.getEntity();    
            if (entity != null) {
            	result = EntityUtils.toString(entity,"UTF-8");//响应实体
            }  
        } catch (Exception e) {  
            throw e;  
        }finally{  
            httpclient.close();  
            response.close();  
        }  
        return result;
    }  

}
