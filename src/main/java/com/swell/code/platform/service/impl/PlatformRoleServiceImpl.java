package com.swell.code.platform.service.impl;

import com.swell.code.platform.dao.PlatformRoleRepository;
import com.swell.code.platform.dao.PlatformRoleMenuRepository;
import com.swell.code.platform.entity.ParamsRoleMenu;
import com.swell.code.platform.entity.PlatformRole;
import com.swell.code.platform.entity.PlatformRoleMenu;
import com.swell.code.platform.service.PlatformRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlatformRoleServiceImpl extends BaseServiceImpl<PlatformRole, String, PlatformRoleRepository> implements PlatformRoleService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PlatformRoleRepository PlatformRoleRepository;

    @Autowired
    private PlatformRoleMenuRepository platformRoleMenuRepository;

    @Override
    public void saveRoleMenu(ParamsRoleMenu paramsRoleMenu) {
        platformRoleMenuRepository.deleteByRoleId(paramsRoleMenu.getRoleId());
        List<PlatformRoleMenu> rmList = new ArrayList<>();
        for (String menuId : paramsRoleMenu.getMenuIds()) {
            PlatformRoleMenu rm = new PlatformRoleMenu();
            rm.setMenuId(menuId);
            rm.setRoleId(paramsRoleMenu.getRoleId());
            rmList.add(rm);
        }
        platformRoleMenuRepository.saveAll(rmList);
    }
}
