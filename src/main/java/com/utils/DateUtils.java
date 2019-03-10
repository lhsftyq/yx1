package com.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	 * 格式化时间
	 * 
	 * @param now
	 * @return
	 */
	public static String getFormatTime(Date now) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 可以方便地修改日期格式
		return dateFormat.format(now).toString();
	}

	/**
	 * 获取当前时间的年
	 */
	public static Integer getYearByCurrentTime() {
		return Integer.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	}

	/**
	 * 获取当前时间的月
	 */
	public static Integer getMonthByCurrentTime() {
		return Integer.valueOf(Calendar.getInstance().get(Calendar.MONTH)) + 1;
	}

	/**
	 * 获取当前时间的日
	 */
	public static Integer getDayByCurrentTime() {
		return Integer.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 获取当前时间的小时
	 */
	public static Integer getHourByCurrentTime() {
		return Integer.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
	}

	/**
	 * 获取当前时间之前或之后几年 year
	 */
	public static String getTimeByYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, year);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
	}

	/**
	 * 获取当前时间之前或之后几月 month
	 */
	public static String getTimeByMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, month);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
	}

	/**
	 * 获取当前时间之前或之后几天 day
	 */
	public static String getTimeByDay(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, day);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
	}

	/**
	 * 获取当前时间之前或之后几小时 hour
	 */
	public static String getTimeByHour(int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

	}

	/**
     *获取当前时间之前或之后几分钟 minute
     */
    public static String getTimeByMinute(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minute);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
    }
}
