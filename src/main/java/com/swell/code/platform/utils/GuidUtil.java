package com.swell.code.platform.utils;

import java.util.UUID;

/**
 * @author fei.yang
 * @time 创建时间：2018年11月22日 上午11:07:27
 * 
 */

public class GuidUtil {

	public static String uuid() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
}
