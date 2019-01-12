package com.swell.code.platform.dao;

import com.swell.code.platform.entity.PlatformUserRole;

public interface PlatformUserRoleRepository extends BaseRepository<PlatformUserRole, String> {

	void deleteByUserId(String userId);
	
	void deleteByRoleId(String roleId);
}
