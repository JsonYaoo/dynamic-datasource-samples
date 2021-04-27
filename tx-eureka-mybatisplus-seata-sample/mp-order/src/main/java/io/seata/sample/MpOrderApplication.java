package io.seata.sample;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("io.seata.sample.mapper")
@EnableFeignClients
@EnableEurekaClient
public class MpOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpOrderApplication.class, args);
    }
}
