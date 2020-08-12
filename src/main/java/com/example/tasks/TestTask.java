package com.example.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    //定义每过3s执行任务
//    @Scheduled(fixedRate = 3000)
    @Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime(){
        System.out.println(dataFormat.format(new Date()));
    }
}
