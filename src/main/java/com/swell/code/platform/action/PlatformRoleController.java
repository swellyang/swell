package com.swell.code.platform.action;

import com.swell.code.platform.common.Result;
import com.swell.code.platform.entity.ParamsRoleMenu;
import com.swell.code.platform.entity.PlatformRole;
import com.swell.code.platform.helper.PlatformUserHelper;
import com.swell.code.platform.service.PlatformRoleService;
import com.swell.code.platform.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/platform/role")
public class PlatformRoleController {

    @Autowired
    private PlatformRoleService PlatformRoleService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView page() {
        ModelAndView mv = new ModelAndView("platform/role");
        return mv;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public Result list() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        List<PlatformRole> list = PlatformRoleService.findAll(sort);
        return Result.success().addData(list);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody PlatformRole paramEntity) {
        PlatformRole PlatformRole = null;
        if (StringUtils.isBlank(paramEntity.getId())) {// 新增
            paramEntity.setCreateTime(DateUtil.currentTime());
            paramEntity.setCreateUser(PlatformUserHelper.getUser().getId());
            PlatformRole = paramEntity;
        } else {// 更新
            PlatformRole = PlatformRoleService.findById(paramEntity.getId());
            String[] ignoreProperties = {"id", "createTime", "createUser"};
            BeanUtils.copyProperties(paramEntity, PlatformRole, ignoreProperties);
            PlatformRole.setModifyTime(DateUtil.currentTime());
            PlatformRole.setModifyUser(PlatformUserHelper.getUser().getId());
        }
        PlatformRoleService.saveOrUpdate(PlatformRole);
        return Result.success();
    }

    @RequestMapping(path = "/saveRoleMenu", method = RequestMethod.POST)
    public Result saveRoleMenu(@RequestBody ParamsRoleMenu params) {
        PlatformRoleService.saveRoleMenu(params);
        return Result.success();
    }

}
