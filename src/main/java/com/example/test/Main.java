package com.example.test;

import com.example.test.services.manager.Executor;
import com.example.test.services.manager.SiteManager;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Executor executor;

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"ae");
        map.put(1,"fj");
        map.put(2,"ko");
        map.put(3,"pt");
        map.put(4,"uz");
        for (int i = 0; i < 5; i++) {
            executor  = new Executor(new SiteManager(),map.get(i));
            executorService.submit(executor);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

    }
}
