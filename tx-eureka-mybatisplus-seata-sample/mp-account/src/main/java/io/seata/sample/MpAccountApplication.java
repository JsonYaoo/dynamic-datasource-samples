package io.seata.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MpAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpAccountApplication.class, args);
    }
}
