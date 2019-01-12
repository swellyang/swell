package com.swell.code.platform.dao;

import com.swell.code.platform.entity.PlatformRoleMenu;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlatformRoleMenuRepository extends BaseRepository<PlatformRoleMenu, String> {

	void deleteByRoleId(String roleId);
	
	void deleteByMenuId(String menuId);
	
	@Query(value = "select menu_id from platform_role_menu where role_id=?1", nativeQuery = true)
	List<String> findAllMenuIdByRoleId(String roleId);
}
