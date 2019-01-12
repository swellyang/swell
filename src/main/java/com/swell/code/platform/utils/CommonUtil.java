package com.swell.code.platform.utils;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author fei.yang
 * @time 创建时间：2018年11月26日 下午3:29:44
 * 
 */

public class CommonUtil {

	public static double getScale(BigInteger v1, BigInteger v2) {
		return v1.doubleValue() / v2.doubleValue();
	}

	// 四舍五入取最低值
	public static double getFloor(Float f) {
		return Math.floor(f * 100) / 100;
	}

	// 返回字符串浮点数，如果没有小数，则返回整数格式的
	public static String truncateFloatIfy(Float f) {
		String s = f + "";
		if (f % 1 == 0) {
			s = f.intValue() + "";
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(getRandomIdcard());
	}

	public static String getPoliceNumber(String s) {
		int len1 = s.split("").length;
		return s.substring(len1 - 6);
	}

	public static String getPoliceName(String s) {
		int len1 = s.split("").length;
		return s.substring(0, len1 - 6);
	}

	public static String getSfzh(){
		String now = DateUtil.formatNow(DateUtil.PatternTypes.datetime_compact);
		return now;
	}

	public static String getRandomIdcard(){
		Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
		int num = (int) ((Math.random() * 9 + 1) * 10000);
		return milliSecond +""+num;
	}
}
