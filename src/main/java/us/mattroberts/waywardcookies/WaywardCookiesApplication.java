package us.mattroberts.waywardcookies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WaywardCookiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaywardCookiesApplication.class, args);
    }

}
