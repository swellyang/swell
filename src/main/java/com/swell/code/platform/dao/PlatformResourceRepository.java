package com.swell.code.platform.dao;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.swell.code.platform.entity.PlatformResource;

public interface PlatformResourceRepository extends BaseRepository<PlatformResource, String> {

	List<PlatformResource> findAllByNameLikeOrCodeLike(String name, String code, Sort sort);
}
