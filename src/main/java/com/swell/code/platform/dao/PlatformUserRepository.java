package com.swell.code.platform.dao;

import com.swell.code.platform.entity.PlatformUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlatformUserRepository extends BaseRepository<PlatformUser, String> {

    PlatformUser findByUsername(String username);

    Page<PlatformUser> findByUsernameLike(String searchText, Pageable pageable);

}
