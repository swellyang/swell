package com.swell.code.platform.dao;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.swell.code.platform.entity.PlatformResource;

public interface PlatformResourceRepository extends BaseRepository<PlatformResource, String> {

	List<PlatformResource> findAllByNameLikeOrUrlLike(String name, String url, Sort sort);
}
