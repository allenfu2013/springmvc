package org.allen.springmvc.job;

import org.allen.springmvc.utils.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestJob {

    @Scheduled(cron = "0/3 * * * * ?")
    public void hello() {
        Logger.info(this, String.format(" ############ hello"));
    }

    @Scheduled(fixedRate = 3000L)
    public void hello1() {
        Logger.info(this, String.format(" ############ hello1"));
    }

    @Scheduled(fixedDelay = 3000L)
    public void hello2() {
        Logger.info(this, String.format(" ############ hello2"));
    }
}
