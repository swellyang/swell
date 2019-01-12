package com.swell.code.platform.dao;

import com.swell.code.platform.entity.PlatformRole;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlatformRoleRepository extends BaseRepository<PlatformRole, String> {

	@Query(value = "select t2.* from platform_user_role t1 left join platform_role t2 on t1.role_id=t2.id where t1.user_id=?1", nativeQuery = true)
	List<PlatformRole> findAllByUserId(String userId);

	@Query(value = "select t2.* from platform_role_resource t1 left join platform_role t2 on t1.role_id=t2.id where t1.resource_id=?1", nativeQuery = true)
	List<PlatformRole> findAllByResourceId(String resourceId);
	
	List<PlatformRole> findAllByNameLikeOrCodeLike(String name, String code, Sort sort);

}
