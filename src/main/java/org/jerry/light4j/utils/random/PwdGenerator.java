package org.jerry.light4j.utils.random;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 密码生成器
 * @author jian
 *
 */
public class PwdGenerator {


    public static String KEY1 = "0123456789";

    public static String KEY11 = "123456789";

    public static String KEY2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String KEY3 = "abcdefghijklmnopqrstuvwxyz";
    
    public static String KEY4 = KEY1+KEY2;
    
    public static String KEY5 = KEY1+KEY3;
    
    public static String KEY6 = KEY2+KEY3;
    
    public static String KEY7 = KEY1+KEY6;
    
    static Random seed;


    static {
    	/*初始化随机数种子*/
        seed = new Random(System.currentTimeMillis());
    }
    
    public static String getRandomValue(int length) {
        return _getPassword(KEY7, length);
    }
    public static String getPassword(String key, int length) {
        return _getPassword(key, length);
    }

    private static String _getPassword(String key, int length) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            sb.append(key.charAt((int) (Math.random() * key.length())));
        }
        return sb.toString();
    }
    
    /**
     * 根据随机种子获取随机数
     * @param range
     * @return
     */
    public static int getRandom(int range) {
        return (int) (seed.nextDouble() * range);
    }
    
    /**
     * 根据起始时间和结束时间获取随机时间
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date randomDate(String beginDate,String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if(start.getTime() >= end.getTime()){
                return null;
            }

            long date = random(start.getTime(),end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    /**
     * 根据随机数获取随机时间戳
     * @param begin
     * @param end
     * @return
     */
    public static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }
}
