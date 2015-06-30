/**
 * Copyright 2014 the original author or authors. All rights reserved.
 */
package com.visionet.project.base.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author huwk
 * @since 0.0.1
 *
 */
public class DateUtil {

	/***
	 * 得到一天的开始时间0:0:0 0:0::0
	 * @param date
	 * @return
	 */
	public static Long beginDateOfDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}
	/**
	 * 时间格式化
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getDateStr(Date date,String pattern){
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}
	
	public static Integer getBetweenDayOfDate(Date beginDate,Date endDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(beginDate);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Long beginTime = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Long endTime = calendar.getTimeInMillis();
		Long betweenDay = (endTime-beginTime)/(24*3600*1000)+1;
		if(betweenDay.intValue() == -1){
			betweenDay = 1L;
		}
		return betweenDay.intValue()<0 ? 0 : betweenDay.intValue();
	}
	
	public static Long dateToLong(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}
	
	public static String getMonthAndDay(Long date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		String weekStr = "";
		switch (weekDay-1) {
		case 0:
			weekStr = "周日";
			break;
		case 1:
			weekStr = "周一";
			break;
		case 2:
			weekStr = "周二";
			break;
		case 3:
			weekStr = "周三";
			break;
		case 4:
			weekStr = "周四";
			break;
		case 5:
			weekStr = "周五";
			break;
		case 6:
			weekStr = "周六";
			break;
		default:
			weekStr = "";
			break;
		}
		return (month+1)+"月"+day+"日"+"  "+weekStr;
	}
}
