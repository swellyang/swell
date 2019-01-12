package com.swell.code.platform.service;

import com.swell.code.platform.dao.PlatformRoleRepository;
import com.swell.code.platform.entity.ParamsRoleMenu;
import com.swell.code.platform.entity.PlatformRole;

import java.util.List;

public interface PlatformRoleService extends BaseService<PlatformRole, String, PlatformRoleRepository> {

    void saveRoleMenu(ParamsRoleMenu paramsRoleMenu);
}
