package com.swell.code.platform.action;

import com.swell.code.platform.common.Result;
import com.swell.code.platform.entity.PlatformResource;
import com.swell.code.platform.helper.PlatformUserHelper;
import com.swell.code.platform.service.PlatformResourceService;
import com.swell.code.platform.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/platform/resource")
public class PlatformResourceController {

    @Autowired
    private PlatformResourceService PlatformResourceService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView page() {
        ModelAndView mv = new ModelAndView("platform/resource");
        return mv;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public Result list() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        List<PlatformResource> list = PlatformResourceService.findAll(sort);
        return Result.success().addData(list);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody PlatformResource paramObject) {
        PlatformResource entity = null;
        if (StringUtils.isBlank(paramObject.getId())) {// 新增
            paramObject.setCreateTime(DateUtil.currentTime());
            paramObject.setCreateUser(PlatformUserHelper.getUser().getId());
            entity = paramObject;
        } else {// 更新
            entity = PlatformResourceService.findById(paramObject.getId());
            String[] ignoreProperties = {"id", "createTime", "createUser"};
            BeanUtils.copyProperties(paramObject, entity, ignoreProperties);
        }
        PlatformResourceService.saveOrUpdate(entity);
        return Result.success();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestParam String id) {
        PlatformResourceService.deleteById(id);
        return Result.success();
    }
}
