package com.swell.code.platform.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Service;

@Service
public class PurviewAuthenticationExceptionHandler implements AuthenticationEntryPoint, Serializable {

    @Value("${custom.security.loginPage}")
    private String loginPage;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static final Log logger = LogFactory.getLog(PurviewAuthenticationExceptionHandler.class);

    private boolean forwardToDestination = false;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        //此种方式不做跳转，只返回状态数据，适用于前后端分离
//        if (authException instanceof InsufficientAuthenticationException) {
//            logger.error("...unauthorized, the url is [" + request.getRequestURI() + "]");
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        }
//        authException.printStackTrace();

        //
        //跳转登录页面
        try {
            logger.info("...[" + request.getRequestURI() + "] Unauthorized");
            if (this.forwardToDestination) {
                logger.info("...Forwarding to " + this.loginPage);
                request.getRequestDispatcher(this.loginPage).forward(request, response);
            } else {
                logger.info("...Redirecting to " + this.loginPage);
                this.redirectStrategy.sendRedirect(request, response, this.loginPage);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
