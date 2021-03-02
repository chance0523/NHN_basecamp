package com.godo.redis.demo.Component;


import com.godo.redis.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class RedisTestCommands {

    private final RedisService redisService;

    @Autowired
    public RedisTestCommands(RedisService redisService) {
        this.redisService = redisService;
    }

    @ShellMethod(value = "redis-test")
    public String redisTest(
            @ShellOption int cnt
    ) {
        long beforeTime = System.currentTimeMillis();

        for (int i = 0; i < cnt; i++) {
            redisService.setStringValue("test", "value");
            redisService.getStringValue("test");
        }

        long afterTime = System.currentTimeMillis();
        long secDiffTime = afterTime - beforeTime;

        return "시간차이(ms) : " + secDiffTime;
    }

}
