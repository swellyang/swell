package com.swell.code.platform.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author fei.yang
 * @time 创建时间：2018年12月19日 下午11:32:37
 * 
 */

public class MyResourceUtil {

	/**
	 * 读取classpath下的文件,只需要传冒号后面的内容即可
	 * 
	 * @param filePath
	 * @return
	 */
	public static String read(String filePath) {
		// InputStream inputStream =
		// getClass().getClassLoader().getResourceAsStream(fileName);
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("classpath:" + filePath);
		StringBuffer strBuff = new StringBuffer();
		try (InputStream inputStream = resource.getInputStream()) {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
			String string = null;
			while ((string = bufferedReader.readLine()) != null) {
				strBuff.append(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strBuff.toString();

	}
}
