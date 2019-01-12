package com.swell.code.platform.helper;

import com.swell.code.platform.entity.PlatformUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class PlatformUserHelper {

	public static PlatformUser getUser() {
		PlatformUser user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
			user = (PlatformUser) authentication.getPrincipal();
			return user;
		}
		return user;
	}

}
