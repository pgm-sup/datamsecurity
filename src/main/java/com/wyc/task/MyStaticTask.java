package com.wyc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class MyStaticTask {

    /**
     * 固定cron配置定时任务
     */
//    @Scheduled(cron = "0/20 * * * * ?")
    public void doTask(){
        System.out.println("执行了MyStaticTask,时间为:"+new Date(System.currentTimeMillis()));
    }
}
