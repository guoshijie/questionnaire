package net.shinc.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName DateUtils 
 * @Description 日期工具类
 * @author guoshijie 
 * @date 2015年9月18日 上午10:19:14  
 */
public class DateUtils {

	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
	
	public static String dateToString(Date date, String pattern){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern); 
			String str = sdf.format(date);
			logger.info("dateToString:"+str);
			return str;
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return null;
	}
	
    /** 
     * 设置时间 
     * @param year 
     * @param month 
     * @param date 
     * @return 
     */  
    public static Calendar setCalendar(int year,int month,int date){  
        Calendar cl = Calendar.getInstance();  
        cl.set(year, month-1, date);  
        return cl;  
    }  
      
    /** 
     * 获取当前时间的前一天时间 
     * @param cl 
     * @return 
     */  
    public static Calendar getBeforeDay(Calendar cl){  
        //使用roll方法进行向前回滚  
        //cl.roll(Calendar.DATE, -1);  
        //使用set方法直接进行设置  
        int day = cl.get(Calendar.DATE);  
        cl.set(Calendar.DATE, day-1);  
        return cl;  
    }  
      
    /** 
     * 获取当前时间的后一天时间 
     * @param cl 
     * @return 
     */  
    public static Calendar getAfterDay(Calendar cl){  
        //使用roll方法进行回滚到后一天的时间  
        //cl.roll(Calendar.DATE, 1);  
        //使用set方法直接设置时间值  
        int day = cl.get(Calendar.DATE);  
        cl.set(Calendar.DATE, day+1);  
        return cl;  
    }
    
    /**
     * 获取前几天的日期list
     * @param num
     * @return
     */
    public static List<String> getBeforeFewsDate(Integer num, String pattern) {
    	List<String> list = new ArrayList<String>();
    	Calendar c = new GregorianCalendar();
    	list.add(dateToString(c.getTime(), pattern));
		for (int i = 0; i > 1 - num; i--) {
			c.add(Calendar.DAY_OF_MONTH, - 1);
			list.add(dateToString(c.getTime(), pattern));
		}
    	return list;
    }
      
    /** 
     * 打印时间 
     * @param cl 
     */  
    public static void printCalendar(Calendar cl) {  
        int year = cl.get(Calendar.YEAR);  
        int month = cl.get(Calendar.MONTH)+1;  
        int day = cl.get(Calendar.DATE);  
        logger.info(year+"-"+month+"-"+day);  
    }  
    
    public static void main(String[] args){  
        //当前时间  
//        Calendar cl = setCalendar(2014,01,01);  
//        logger.info("当前时间:");  
//        printCalendar(cl);  
//        //前一天  
//        cl = setCalendar(2014,01,01);  
//        getBeforeDay(cl);  
//        logger.info("前一天:");  
//        printCalendar(cl);  
//        //后一天  
//        cl = setCalendar(2014,01,01);  
//        getAfterDay(cl);  
//        logger.info("后一天:");  
//        printCalendar(cl);  
    	
    	getBeforeFewsDate(7, "yyyy-MM-dd");
    } 
}
