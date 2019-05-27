package org.com.hello.world.common.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 通用工具类
 * @author ht
 *
 */
public class BaseUtil {
	
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	/**
	 * 获取UUID
	 * @return
	 */
	public static String getUUID64(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 获取当前时间戳
	 * @return
	 */
	public static long getCurrentTimeStamp(){
		return new Date().getTime();
	}
	
	/**
	 * 时间戳转时间
	 * @param timeStamp
	 * @return
	 */
	public static Date timeStamp2Date(long timeStamp){
		return new Date(timeStamp);
	}
	
	/**
	 * 字符串转日期
	 * @param str
	 * @return
	 */
	public static Date string2Date(String str){
		try {
			return SIMPLE_DATE_FORMAT.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 日期转字符串
	 * @param date
	 * @return
	 */
	public static String date2String(Date date){
		return SIMPLE_DATE_FORMAT.format(date);
	}
	
}
