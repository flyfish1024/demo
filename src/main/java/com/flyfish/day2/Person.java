package com.flyfish.day2;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Person
 * @Description: 配置文件测试类
 * @Author 王飞鱼
 * @Date 2020-4-21
 * @Version V1.0
 **/
@Getter
@Setter
@ToString
@Configuration
@PropertySource(value = {"classpath:profile/person.properties"})
@ConfigurationProperties(prefix = "person")
public class Person {
    private int id;
    private String name;
    private boolean isAdult;
    private Map<Object,Object> phone;
    private List<Object> pets;
    private Department department;
}
