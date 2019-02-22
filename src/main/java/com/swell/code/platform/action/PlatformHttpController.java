package com.swell.code.platform.action;

import com.swell.code.platform.entity.PlatformUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * HTTP测试类
 */
@RestController
@RequestMapping("/platform/http")
public class PlatformHttpController {


    @Autowired
    RestTemplate restTemplate;

    //http get
    @RequestMapping(value = "/menus1")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String url = "https://news.baidu.com/widget?ajax=json&id=ad";
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }

    // http post
    @RequestMapping(value = "/menus2", method = RequestMethod.POST)
    public String createProducts(@RequestParam String roleId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(roleId, headers);
        String url = "http://localhost:8080/swell/platform/menu/treeData";
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
    }
}
