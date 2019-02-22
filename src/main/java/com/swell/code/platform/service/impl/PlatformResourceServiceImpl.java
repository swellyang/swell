package com.swell.code.platform.service.impl;

import com.swell.code.platform.dao.PlatformResourceRepository;
import com.swell.code.platform.entity.PlatformResource;
import com.swell.code.platform.service.PlatformResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class PlatformResourceServiceImpl extends BaseServiceImpl<PlatformResource, String, PlatformResourceRepository> implements PlatformResourceService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PlatformResourceRepository PlatformResourceRepository;

    @Override
    public List<PlatformResource> findAll(String name, String url) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        return PlatformResourceRepository.findAllByNameLikeOrUrlLike(name, url, sort);
    }
}
