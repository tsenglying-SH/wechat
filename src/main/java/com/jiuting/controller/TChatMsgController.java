package com.jiuting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Tsenglying
 * @Date 2020/7/23 14:21
 * @Version 1.0
 **/
@RestController
public class TChatMsgController {
    @RequestMapping("/hello")
    public String Test(){
        return "hello123";
    }
}
