package com.swell.code.platform.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.swell.code.platform.common.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

@Service
public class PurviewLoginFailuerHandler implements AuthenticationFailureHandler {

    private static final Log logger = LogFactory.getLog(PurviewLoginFailuerHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex)
            throws IOException {
        response.setCharacterEncoding("utf-8");
        logger.info("Login error...");
        logger.error(ex);
        PrintWriter out = response.getWriter();
        String msg = "登陆失败";
        if (ex instanceof BadCredentialsException) {
            msg = "账号或密码错误";
        }
        //
        else if (ex instanceof UsernameNotFoundException) {
            msg = "账号不存在";
        }
        //
        else if (ex instanceof AccountExpiredException) {
            msg = "账号已过期";
        }
        //
        else if (ex instanceof LockedException) {
            msg = "账号已锁定";
        }
        //
        else if (ex instanceof DisabledException) {
            msg = "账号已禁用";
        }
        //
        else if (ex.getCause() instanceof CredentialsExpiredException) {
            msg = "密码不正确或已过期";
        }
        out.print(JSONObject.toJSON(Result.error(msg)));
        out.flush();
        out.close();
    }

}
