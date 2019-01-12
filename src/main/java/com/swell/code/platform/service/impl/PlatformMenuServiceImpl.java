package com.swell.code.platform.service.impl;

import com.swell.code.platform.common.Constant;
import com.swell.code.platform.dao.PlatformMenuRepository;
import com.swell.code.platform.dao.PlatformRoleMenuRepository;
import com.swell.code.platform.entity.PlatformMenu;
import com.swell.code.platform.helper.SqlHelper;
import com.swell.code.platform.service.PlatformMenuService;
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
public class PlatformMenuServiceImpl extends BaseServiceImpl<PlatformMenu, String, PlatformMenuRepository> implements PlatformMenuService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PlatformMenuRepository platformMenuRepository;

    @Autowired
    private PlatformRoleMenuRepository platformRoleMenuRepository;

    @Override
    public List<PlatformMenu> findOwnerTreeData(String userId) {
        List<PlatformMenu> rsList = new ArrayList<>();
        Query nativeQuery = entityManager.createNativeQuery(SqlHelper.getSql(Constant.Statements.QUERY_MENU_BYUSER), PlatformMenu.class);
        nativeQuery.setParameter("userId", userId);
        List<PlatformMenu> menuList = nativeQuery.getResultList();
        for (PlatformMenu menu : menuList) {
            String menuId = menu.getId();
            if (StringUtils.isBlank(menu.getParentId())) {
                List<PlatformMenu> children = new ArrayList<PlatformMenu>();
                for (PlatformMenu child : menuList) {
                    String parentId = child.getParentId();
                    if (!StringUtils.isEmpty(parentId) && child.getParentId().equals(menuId)) {
                        children.add(child);
                    }
                }
                menu.setChildren(children);
                rsList.add(menu);
            }
        }
        return rsList;
    }


    @Override
    public List<PlatformMenu> findAllTreeData(String roleId) {
        //获取当前角色关联的menuId
        List<String> menuIds = platformRoleMenuRepository.findAllMenuIdByRoleId(roleId);
        //查询全部菜单
        List<PlatformMenu> rsList = new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.ASC, "sortNo");
        List<PlatformMenu> menuList = platformMenuRepository.findAll(sort);
        for (PlatformMenu menu : menuList) {
            String menuId = menu.getId();
            if (StringUtils.isBlank(menu.getParentId())) {
                List<PlatformMenu> children = new ArrayList<>();
                for (PlatformMenu child : menuList) {
                    String parentId = child.getParentId();
                    if (StringUtils.isNotBlank(parentId) && child.getParentId().equals(menuId)) {
                        child.setTitle(child.getName());
                        if (menuIds.contains(child.getId())) {
                            child.setChecked(true);
                        }
                        children.add(child);
                    }
                }
                menu.setTitle(menu.getName());
                menu.setChildren(children);
                menu.setExpand(true);
                rsList.add(menu);
            }
        }
        return rsList;
    }

    @Override
    public List<PlatformMenu> findAllMenus() {
        List<PlatformMenu> resultList = new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.ASC, "sortNo");
        List<PlatformMenu> menuList = platformMenuRepository.findAll(sort);
        for (PlatformMenu menu : menuList) {
            String menuId = menu.getId();
            if (StringUtils.isBlank(menu.getParentId())) {
                resultList.add(menu);
                for (PlatformMenu child : menuList) {
                    String parentId = child.getParentId();
                    if (!StringUtils.isEmpty(parentId) && child.getParentId().equals(menuId)) {
                        resultList.add(child);
                    }
                }
            }
        }
        return resultList;
    }

    @Override
    @Transactional
    public void deleteByParentId(String parentId) {
        platformMenuRepository.deleteByParentId(parentId);
    }

}
