package com.quick.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间 日期 与字符串 转换处理工具类
 * @author s
 *
 */
public class DateFormat {
	
	/**
	 * 获取当前年月日字符串
	 * 20130708
	 * @return
	 */
	public static String getYmd(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		return ""+year+(month <10?"0"+month:month)+(day <10?"0"+day:day);
	}
	
	/**
	 * 把字符串转换成Date
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date formatDate(String dateSource,String format){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = simpleDateFormat.parse(dateSource);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 把日期转换成特定字符串
	 * @param dateSource
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static String formatString(Date dateSource,String format){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String str = null;
		str = simpleDateFormat.format(dateSource);
		return str;
	}
	
	public static void main(String[] args){
		System.out.println(DateFormat.formatString(new Date(),"yyyyMMddHHmmss"));
	}

}
