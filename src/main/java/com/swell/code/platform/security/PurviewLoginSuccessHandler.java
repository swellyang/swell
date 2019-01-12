package com.swell.code.platform.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.swell.code.platform.common.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class PurviewLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${custom.security.loginSuccessUrl}")
    private String loginSuccessUrl;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private static final Log logger = LogFactory.getLog(PurviewLoginSuccessHandler.class);

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException {

        response.setCharacterEncoding("utf-8");
        logger.info("Login success...");

        PrintWriter out = response.getWriter();
        out.print(JSONObject.toJSON(Result.success()));
        out.flush();
        out.close();

        //logger.info("Login success,Redirecting to " + this.loginSuccessUrl);
        //this.redirectStrategy.sendRedirect(request, response, this.loginSuccessUrl);

    }


}
