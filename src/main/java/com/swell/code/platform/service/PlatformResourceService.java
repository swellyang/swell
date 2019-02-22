package com.swell.code.platform.service;

import com.swell.code.platform.dao.PlatformResourceRepository;
import com.swell.code.platform.entity.PlatformResource;

import java.util.List;

public interface PlatformResourceService extends BaseService<PlatformResource, String, PlatformResourceRepository> {

    List<PlatformResource> findAll(String name, String url);
}
