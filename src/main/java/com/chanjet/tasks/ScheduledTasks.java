package com.chanjet.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.chanjet.service.*;

import static com.chanjet.constants.Constants.ROWNUM;
import static com.chanjet.constants.Constants.TEST_KEY;

@Component
public class ScheduledTasks {
    private static final Logger Log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private Tasks1 task1;
    @Autowired
    private Tasks2 task2;
    @Scheduled(fixedRate = 2000)
    public void tasks2() {
            task2.show();
            task2.findagentinfo(ROWNUM);
    }
    @Scheduled(fixedRate = 3000)
    public void tasks1() throws Exception{
        task1.show();
        task1.findtransdetail(ROWNUM);
    }
}
