package com.swell.code.platform.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.swell.code.platform.dao.PlatformRoleRepository;
import com.swell.code.platform.dao.PlatformUserRepository;
import com.swell.code.platform.entity.PlatformRole;
import com.swell.code.platform.entity.PlatformUser;

@Service
public class PurviewUserDetailService implements UserDetailsService {

    @Autowired
    private PlatformUserRepository platformUserRepository;

    @Autowired
    private PlatformRoleRepository platformRoleRepository;

    private static final Log logger = LogFactory.getLog(PurviewUserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PlatformUser user = platformUserRepository.findByUsername(s);

        if (user == null) {
            logger.error("Login Failure : Account Not Found");
            throw new UsernameNotFoundException("Account Not Found");
        }
        //
        else if (!user.isAccountNonExpired()) {
            logger.error("Login Failure : Account Expired");
            throw new AccountExpiredException("Account Expired");
        }
        //
        else if (!user.isAccountNonLocked()) {
            logger.error("Login Failure : Account Locked");
            throw new LockedException("Account Locked");
        }
        //
        else if (!user.isEnabled()) {
            logger.error("Login Failure : Account Disabled");
            throw new DisabledException("Account Disabled");
        }
        //
        else if (!user.isCredentialsNonExpired()) {
            logger.error("Login Failure : Credentials Expired");
            throw new CredentialsExpiredException("Credentials Expired");
        }

        user.setAuthorities(getGrantedAuthorities(user));
        return user;
    }

    /**
     * 查找当前用户包含的角色
     *
     * @param user
     * @return
     */
    private List<GrantedAuthority> getGrantedAuthorities(PlatformUser user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<PlatformRole> list = platformRoleRepository.findAllByUserId(user.getId());
        for (PlatformRole role : list) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        return authorities;
    }
}
