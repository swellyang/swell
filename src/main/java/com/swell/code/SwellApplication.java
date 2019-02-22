package com.swell.code;

import com.swell.code.business.dao.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
@EnableScheduling
@SpringBootApplication
public class SwellApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SwellApplication.class, args);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {

        return "index";
    }

    @RequestMapping(path = "/loginForm", method = RequestMethod.GET)
    public String loginForm() {

        return "login";
    }

    @RequestMapping(path = "/accessDenied", method = RequestMethod.GET)
    public String accessDenied() {

        return "access_denied";
    }


    /**
     * 定时任务线程池，配置此项可以多线程并行
     *
     * @return
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler pool = new ThreadPoolTaskScheduler();
        pool.setPoolSize(20);
        pool.setThreadNamePrefix("swell-task");
        return pool;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    @Qualifier("baoma")
    private Car car;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Do Something ... After Application Runner");
        System.out.println(car.getName());
    }
}
