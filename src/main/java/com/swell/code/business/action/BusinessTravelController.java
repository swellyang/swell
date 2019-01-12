package com.swell.code.business.action;

import com.alibaba.fastjson.JSONObject;
import com.swell.code.platform.utils.HttpsUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/business/travel")
public class BusinessTravelController {

    public static String baseUrl = "https://kyfw.12306.cn/passport/";
    public static String appid = "otn";


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView page() {
        ModelAndView mv = new ModelAndView("business/travel");
        return mv;
    }

    /**
     * 初始化操作，获取cookie和验证码图片
     *
     * @return
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public JSONObject init() {
        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        CookieHandler.setDefault(manager);
        String url = baseUrl + "captcha/captcha-image64?login_site=E&module=login&rand=sjrand&1546760899557&_=1546760897853";
        String rs = HttpsUtil.get(url);
        System.out.println("%%%\t" + rs);
        JSONObject resultJson = JSONObject.parseObject(rs);
        if (resultJson.getString("result_code").equals("0")) {
            System.out.println("%%%\t获取验证码成功");
        }
        return resultJson;
    }

    /**
     * 登录操作，先验证验证码，在验证账号密码
     *
     * @param vcodes
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public JSONObject loginProcess(HttpServletRequest request, @RequestParam String vcodes, @RequestParam String username, @RequestParam String password) {
        // 验证验证码
        String url = baseUrl + "captcha/captcha-check?rand=sjrand&login_site=E&answer=" + vcodes;
        String rs = HttpsUtil.get(url);
        System.out.println("%%%\t" + rs);
        JSONObject resultJson = JSONObject.parseObject(rs);
        if (resultJson.getString("result_code").equals("4")) {
            System.out.println("%%%\t验证码验证成功，接下来验证账号密码");

            // 验证账号密码
            url = baseUrl + "web/login?";
            Map<String, String> paramsMap = new HashMap<>();
            paramsMap.put("username", username);
            paramsMap.put("password", password);
            paramsMap.put("appid", appid);
            paramsMap.put("answer", vcodes);
            rs = HttpsUtil.post(url, paramsMap);
            resultJson = JSONObject.parseObject(rs);
            if (resultJson.getString("result_code").equals("0")) {
                System.out.println("%%%\t登陆成功!");
                String uamtk = resultJson.getString("uamtk");
                sessionPut(request, "uamtk", uamtk);
                sessionPut(request, "username", username);
            }
        }
        return resultJson;
    }

    @RequestMapping(value = "/queryTickits", method = RequestMethod.GET)
    public JSONObject queryTickits(@RequestParam String fromStation, @RequestParam String toStation, @RequestParam String trainDate) {
        String url = "https://kyfw.12306.cn/otn/leftTicket/queryZ?";
        url += "leftTicketDTO.train_date=" + trainDate;
        url += "&leftTicketDTO.from_station=" + fromStation;
        url += "&leftTicketDTO.to_station=" + toStation;
        url += "&purpose_codes=ADULT";
        System.out.println("%%%\t" + url);
        String rs = HttpsUtil.get(url);
        System.out.println("%%%\t" + rs);
        JSONObject resultJson = JSONObject.parseObject(rs);
        if (resultJson.getBoolean("status")) {
            System.out.println("%%%\t查询车票成功");
        }
        return resultJson;
    }

    public void sessionPut(HttpServletRequest request, String key, Object val) {
        request.getSession().setAttribute(key, val);
    }

}
