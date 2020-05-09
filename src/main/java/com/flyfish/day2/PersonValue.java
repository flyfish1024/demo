package com.flyfish.day2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName PersonValue
 * @Description: @Value 演示
 * @Author 王飞鱼
 * @Date 2020-4-27
 * @Version V1.0
 **/

@ToString
@Component
public class PersonValue {
    @Value("1")//字面量
    private int id;
    @Value("${person.name}")//配置文件中的值
    private String name;
    @Value("#{18*1}")//SpEL表达式
    private int age;
    //使用@Value注解修饰的字段不需要提供set方法

}
