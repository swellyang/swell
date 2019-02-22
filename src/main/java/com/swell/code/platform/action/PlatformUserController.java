package com.swell.code.platform.action;

import com.swell.code.platform.common.Result;
import com.swell.code.platform.entity.ParamsRoleMenu;
import com.swell.code.platform.entity.PlatformUser;
import com.swell.code.platform.helper.PlatformUserHelper;
import com.swell.code.platform.service.PlatformUserService;
import com.swell.code.platform.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/platform/user")
public class PlatformUserController {

    @Autowired
    private PlatformUserService PlatformUserService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView page() {
        ModelAndView mv = new ModelAndView("platform/user");
        return mv;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam int pageNumber, @RequestParam int pageSize, @RequestParam String startDate, @RequestParam String endDate, @RequestParam String searchText) {
        Page<PlatformUser> page = PlatformUserService.findAll(pageNumber, pageSize, startDate, endDate, searchText);
        return Result.success().addData(page);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody PlatformUser paramEntity) {
        PlatformUser platformUser;
        if (StringUtils.isBlank(paramEntity.getId())) {// 新增
            platformUser = new PlatformUser();
            platformUser.setCreateTime(DateUtil.currentTime());
            platformUser.setCreateUser(PlatformUserHelper.getUser().getId());
        } else {// 更新
            platformUser = PlatformUserService.findById(paramEntity.getId());
            platformUser.setModifyTime(DateUtil.currentTime());
            platformUser.setModifyUser(PlatformUserHelper.getUser().getId());
        }
        platformUser.setUsername(paramEntity.getUsername());
        platformUser.setRealName(paramEntity.getRealName());
        platformUser.setGender(paramEntity.getGender());
        platformUser.setBirthday(paramEntity.getBirthday());
        platformUser.setContactInformation(paramEntity.getContactInformation());
        PlatformUserService.saveOrUpdate(platformUser);
        return Result.success();
    }


}
