package com.swell.code.platform.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class PurviewLogoutHandler implements LogoutHandler {

	private static final Log logger = LogFactory.getLog(PurviewLogoutHandler.class);

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		response.setCharacterEncoding("utf-8");
		logger.info("Login success...");

	}

}
