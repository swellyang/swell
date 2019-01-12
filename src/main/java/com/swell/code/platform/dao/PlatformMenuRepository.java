package com.swell.code.platform.dao;

import com.swell.code.platform.entity.PlatformMenu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlatformMenuRepository extends BaseRepository<PlatformMenu, String> {

	@Query(value = "select t2.* from platform_role_menu t1 left join platform_menu t2 on t1.menu_id=t2.id where t1.role_id=?1", nativeQuery = true)
	List<PlatformMenu> findAllByRoleId(String roleId);
	
	@Modifying
	@Query(value = "delete from platform_menu where parent_id=?1", nativeQuery = true)
	void deleteByParentId(String parentId);

}
