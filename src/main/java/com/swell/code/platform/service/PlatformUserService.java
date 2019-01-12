package com.swell.code.platform.service;

import org.springframework.data.domain.Page;

import com.swell.code.platform.dao.PlatformUserRepository;
import com.swell.code.platform.entity.PlatformUser;

public interface PlatformUserService extends BaseService<PlatformUser, String, PlatformUserRepository> {

    PlatformUser findByUsername(String username);

    Page<PlatformUser> findAll(int pageNumber, int pageSize);

    Page<PlatformUser> findAll(int pageNumber, int pageSize, String startDate, String endDate, String searchText);


}
