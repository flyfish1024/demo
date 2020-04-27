package com.flyfish.day1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName IndexController
 * @Description: TODO
 * @Author 王飞鱼
 * @Date 2020-4-21
 * @Version V1.0
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
