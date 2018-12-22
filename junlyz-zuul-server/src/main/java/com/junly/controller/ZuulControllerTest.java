package com.junly.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ZuulControllerTest
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/22 0022 20:42
 * @Version 1.0
 **/
@RestController
public class ZuulControllerTest {

    @RequestMapping("/zuultest")
    public String zuulTest(){
        return "zuultest";
    }

}
