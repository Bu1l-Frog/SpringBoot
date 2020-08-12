package com.example.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("tasks")
public class DoTask {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("test1")
    public Long test1() throws Exception{

        long start = System.currentTimeMillis();

        Future<Boolean> a = asyncTask.doTask();
        Future<Boolean> b = asyncTask.doTask1();

        while(!a.isDone() || !b.isDone()){
            if (a.isDone() && b.isDone()){
                break;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println(end-start);
        return (end-start);
    }
}
