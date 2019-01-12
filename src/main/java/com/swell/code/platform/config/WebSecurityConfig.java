package com.swell.code.platform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.swell.code.platform.security.PurviewAccessDeniedHandler;
import com.swell.code.platform.security.PurviewAuthenticationExceptionHandler;
import com.swell.code.platform.security.PurviewFilterSecurityInterceptor;
import com.swell.code.platform.security.PurviewLoginFailuerHandler;
import com.swell.code.platform.security.PurviewLoginSuccessHandler;
import com.swell.code.platform.security.PurviewLogoutHandler;
import com.swell.code.platform.security.PurviewUserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PurviewUserDetailService purviewUserDetailService;

	@Autowired
	private PurviewLoginSuccessHandler purviewLoginSuccessHandler;

	@Autowired
	private PurviewLoginFailuerHandler purviewLoginFailuerHandler;

	@Autowired
	private PurviewAccessDeniedHandler purviewAccessDeniedHandler;

	@Autowired
	private PurviewAuthenticationExceptionHandler purviewAuthenticationExceptionHandler;

	@Autowired
	private PurviewLogoutHandler purviewLogoutHandler;

	@Autowired
	private PurviewFilterSecurityInterceptor filterSecurityInterceptor;

	@Value("${custom.security.loginPage}")
	private String loginPage;

	@Value("${custom.security.loginProcessingUrl}")
	private String loginProcessingUrl;

	@Value("${custom.security.logoutUrl}")
	private String logoutUrl;

	@Value("${custom.security.ignoreAll}")
	private String ignoreAll;

	@Value("${custom.security.permitAll}")
	private String permitAll;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("test12").password("123456").roles("USER");
		auth.userDetailsService(purviewUserDetailService).passwordEncoder(passwordEncoder());
		auth.eraseCredentials(false);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(ignoreAll.split(","));
		super.configure(web);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 禁用CSRF,不然security会对所有post进行拦截
		http.csrf().disable();

		// 配置同域可加载iframe
		http.headers().frameOptions().sameOrigin();

		// 配置过滤器
		http.addFilterBefore(filterSecurityInterceptor, FilterSecurityInterceptor.class);

		// 配置认证失败处理
		ExceptionHandlingConfigurer<HttpSecurity> exceptionHandlingConfigurer = http.exceptionHandling();
		exceptionHandlingConfigurer.authenticationEntryPoint(purviewAuthenticationExceptionHandler);
		exceptionHandlingConfigurer.accessDeniedHandler(purviewAccessDeniedHandler);

		// 配置所有用户可访问的请求(包括匿名用户)
		http.authorizeRequests().antMatchers(permitAll.split(",")).permitAll();

		// 配置登录页面逻辑,所有用户可访问(包括匿名用户)
		FormLoginConfigurer<HttpSecurity> loginConfigurer = http.formLogin();
		loginConfigurer.loginPage(loginPage);
		loginConfigurer.loginProcessingUrl(loginProcessingUrl);
		loginConfigurer.failureHandler(purviewLoginFailuerHandler);
		loginConfigurer.successHandler(purviewLoginSuccessHandler);
		loginConfigurer.permitAll();

		// 配置登出页面逻辑,所有用户可访问(包括匿名用户)
		LogoutConfigurer<HttpSecurity> logoutConfigurer = http.logout();
		logoutConfigurer.logoutUrl(logoutUrl);
		logoutConfigurer.addLogoutHandler(purviewLogoutHandler);
		logoutConfigurer.permitAll();

		// 配置请求认证
		http.authorizeRequests().anyRequest().authenticated();

	}

}