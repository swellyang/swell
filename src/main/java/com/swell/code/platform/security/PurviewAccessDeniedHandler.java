package com.swell.code.platform.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

@Service
public class PurviewAccessDeniedHandler implements AccessDeniedHandler {

	@Value("${custom.security.accessDeniedPage}")
	private String accessDeniedPage;

	private static final Log logger = LogFactory.getLog(PurviewAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
		logger.error("...access denied, the url is [" + request.getRequestURI() + "]");
		response.setStatus(HttpStatus.FORBIDDEN.value());

		// 跳转登录访问被拒页面
		//logger.info("...going access denied page");
		//response.sendRedirect(accessDeniedPage);
	}
}
