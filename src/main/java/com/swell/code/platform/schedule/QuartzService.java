package com.swell.code.platform.schedule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QuartzService {

    private static final Log logger = LogFactory.getLog(QuartzService.class);

    // 是否开启统计
    @Value("${custom.schedule.cron-on}")
    private boolean cronOn;

    @Scheduled(cron = "${custom.schedule.cron-test}")
    public void test() {
        if (cronOn) {
            logger.info("------------------------------------开始执行任务------------------------------------");


            logger.info("------------------------------------结束执行任务------------------------------------");
        }
    }


}
