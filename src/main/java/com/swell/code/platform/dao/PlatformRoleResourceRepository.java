package com.swell.code.platform.dao;

import com.swell.code.platform.entity.PlatformRoleResource;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlatformRoleResourceRepository extends BaseRepository<PlatformRoleResource, String> {

	void deleteByRoleId(String roleId);
	
	void deleteByResourceId(String resourceId);
	
	@Query(value = "select resource_id from platform_role_resource where role_id=?1", nativeQuery = true)
	List<String> findAllResultIdByRoleId(String roleId);
}
