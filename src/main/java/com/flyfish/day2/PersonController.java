package com.flyfish.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName PersonController
 * @Description: 配置文件测试
 * @Author 王飞鱼
 * @Date 2020-4-26
 * @Version V1.0
 **/
@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    Person person;
    @Autowired
    PersonValue personValue;

    @RequestMapping("/get")
    @ResponseBody
    public String get(){
        return person.toString();
    }



    @RequestMapping("/getValue")
    @ResponseBody
    public String getValue(){
        return personValue.toString();
    }
}
