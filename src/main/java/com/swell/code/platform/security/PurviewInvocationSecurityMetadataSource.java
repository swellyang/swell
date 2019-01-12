package com.swell.code.platform.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.swell.code.platform.helper.SqlHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import com.swell.code.platform.dao.PlatformResourceRepository;
import com.swell.code.platform.dao.PlatformRoleRepository;
import com.swell.code.platform.entity.PlatformResource;
import com.swell.code.platform.entity.PlatformRole;

@Service
public class PurviewInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private static final Log log = LogFactory.getLog(PurviewInvocationSecurityMetadataSource.class);
	
	@Autowired
	private PlatformResourceRepository platformResourceRepository;
	@Autowired
	private PlatformRoleRepository platformRoleRepository;

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public PurviewInvocationSecurityMetadataSource() {
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		FilterInvocation filterInvocation = (FilterInvocation) object;
		// String requestUrl = ((FilterInvocation) object).getRequestUrl();
		Iterator<String> iter = resourceMap.keySet().iterator();
		while (iter.hasNext()) {
			String resourceURL = iter.next();
			RequestMatcher urlMatcher = new AntPathRequestMatcher(resourceURL);
			if (urlMatcher.matches(filterInvocation.getHttpRequest())) {
				return resourceMap.get(resourceURL);
			}
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}

	@PostConstruct
	private void loadResourceDefine() {
		if (resourceMap == null) {
			resourceMap = new HashMap<>();
		} else {
			resourceMap.clear();
		}
		List<PlatformResource> resources = platformResourceRepository.findAll();
		for (PlatformResource resource : resources) {
			List<PlatformRole> roles = platformRoleRepository.findAllByResourceId(resource.getId());
			List<ConfigAttribute> configAttrs = new ArrayList<>();
			for (PlatformRole role : roles) {
				ConfigAttribute attr = new SecurityConfig(role.getCode());
				configAttrs.add(attr);
			}
			resourceMap.put(resource.getUrl(), configAttrs);
		}
		log.info("load security resourceMap success......");



	}
}
