package com.ssm.configuration;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfiguration {

    @Bean
    public ExecutorService executorService(){
        return new ThreadPoolExecutor(10, 20, 120, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100),
                new BasicThreadFactory.Builder().namingPattern("ssmlog-%d")
                        .daemon(true).build(),
                new ThreadPoolExecutor.AbortPolicy());
    }
}
