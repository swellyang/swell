package com.swell.code.platform.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class PurviewAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication auth, Object o, Collection<ConfigAttribute> configAttrs) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttrs == null) {
            return;
        }
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        for (ConfigAttribute configAttr : configAttrs) {
            String roleCode = configAttr.getAttribute();
            for (GrantedAuthority ga : authorities) {
                if (roleCode.equals(ga.getAuthority().trim())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("没有权限访问");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
