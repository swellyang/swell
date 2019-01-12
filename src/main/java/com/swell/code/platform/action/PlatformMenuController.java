package com.swell.code.platform.action;

import com.swell.code.platform.common.Result;
import com.swell.code.platform.entity.PlatformMenu;
import com.swell.code.platform.helper.PlatformUserHelper;
import com.swell.code.platform.service.PlatformMenuService;
import com.swell.code.platform.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/platform/menu")
public class PlatformMenuController {

    @Autowired
    private PlatformMenuService platformMenuService;


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView page() {
        ModelAndView mv = new ModelAndView("platform/menu");
        return mv;
    }

    //加载菜单列表-只加载能看到的
    @RequestMapping(path = "/ownerList", method = RequestMethod.GET)
    public Result ownerList() {
        String userId = PlatformUserHelper.getUser().getId();
        List<PlatformMenu> ownList = platformMenuService.findOwnerTreeData(userId);
        return Result.success().addData(ownList);
    }

    //加载菜单列表，默认勾选有权限的
    @RequestMapping(path = "/treeData", method = RequestMethod.GET)
    public Result treeData(@RequestParam String roleId) {
        List<PlatformMenu> treeList = platformMenuService.findAllTreeData(roleId);
        return Result.success().addData(treeList);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public Result list() {
        List<PlatformMenu> list = platformMenuService.findAllMenus();
        return Result.success().addData(list);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody PlatformMenu paramEntity) {
        PlatformMenu platformMenu = null;
        if (StringUtils.isBlank(paramEntity.getId())) {// 新增
            paramEntity.setCreateTime(DateUtil.currentTime());
            paramEntity.setCreateUser(PlatformUserHelper.getUser().getId());
            platformMenu = paramEntity;
        } else {// 更新
            platformMenu = platformMenuService.findById(paramEntity.getId());
            String[] ignoreProperties = {"id", "systemFlag", "createTime", "createUser"};
            BeanUtils.copyProperties(paramEntity, platformMenu, ignoreProperties);
            platformMenu.setModifyTime(DateUtil.currentTime());
            platformMenu.setModifyUser(PlatformUserHelper.getUser().getId());
        }
        platformMenuService.saveOrUpdate(platformMenu);
        return Result.success();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestParam String id) {
        platformMenuService.deleteById(id);
        return Result.success();
    }

}
