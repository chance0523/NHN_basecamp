package com.godo.redis.demo;

import com.godo.redis.demo.service.RedisService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
@Log4j2
public class DemoApplication {

    private static RedisService redisService;

    @Autowired
    public DemoApplication(RedisService redisService) {
        this.redisService = redisService;
    }

    public static void main(String[] args) throws Exception {

        SpringApplication.run(DemoApplication.class, args);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("명령어를 입력하세요. 예시) redis-test 10000");

        String input = br.readLine();
        int cnt = Integer.parseInt(input.split("redis-test ")[1]);

        long beforeTime = System.currentTimeMillis();

        for (int i = 0; i < cnt; i++) {
            redisService.setStringValue("test", "value");
            redisService.getStringValue("test");
        }

        long afterTime = System.currentTimeMillis();
        long secDiffTime = afterTime - beforeTime;

        log.info("------------------------");
        log.info("소요 시간(ms) : " + secDiffTime);
    }

}
