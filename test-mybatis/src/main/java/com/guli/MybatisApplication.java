package com.guli;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.guli.mapper")
//@EnableEurekaClient //注册到服务中
@EnableCaching
//这个注解是用来 设置sesion的时间，和在网关访问的情况下立即去redis拿数据
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300,redisFlushMode = RedisFlushMode.IMMEDIATE)
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
