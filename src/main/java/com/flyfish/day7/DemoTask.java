package com.flyfish.day7;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DemoTask
 * @Description: SpringBoot(七) 定时任务
 * @Author 王飞鱼
 * @Date 2020-5-17
 * @Version V1.0
 **/
@Component
public class DemoTask {
    /**
     * 每隔6秒自动报时
     */
    @Scheduled(fixedRate = 6000)
    public void chiming(){
        System.out.println("现在时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
