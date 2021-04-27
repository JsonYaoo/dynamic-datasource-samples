package io.seata.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */
@SpringBootApplication
@EnableEurekaClient
public class MpStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpStorageApplication.class, args);
    }
}
