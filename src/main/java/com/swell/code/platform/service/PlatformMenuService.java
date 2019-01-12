package com.swell.code.platform.service;

import com.swell.code.platform.dao.PlatformMenuRepository;
import com.swell.code.platform.entity.PlatformMenu;

import java.util.List;

public interface PlatformMenuService extends BaseService<PlatformMenu, String, PlatformMenuRepository> {


    /**
     * 只加载拥有的树形结构菜单
     *
     * @param userId
     * @return
     */
    List<PlatformMenu> findOwnerTreeData(String userId);

    /**
     * 加载全部树形结构菜单，角色匹配到的菜单checked属性为true
     *
     * @param roleId
     * @return
     */
    List<PlatformMenu> findAllTreeData(String roleId);

    /**
     * 加载全部菜单,按顺序加载
     *
     * @return
     */
    List<PlatformMenu> findAllMenus();

    /**
     * 根据父菜单删除子菜单
     *
     * @param parentId
     */
    void deleteByParentId(String parentId);
}
