package com.chanjet.service;

import com.chanjet.entity.AgentInfo;
import com.chanjet.mapper.AgentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tasks2 {
    private static final Logger Logger = LoggerFactory.getLogger(Tasks2.class);
    @Autowired
    private AgentMapper agentMapper;

    public void show(){
        // Logger.info("+++++++++定时任务tasks2打印+++++++++++++");
    }

    public void findagentinfo(Integer RowNum) throws Exception {

        List<AgentInfo> agentInfoList = agentMapper.findAgentinfo(RowNum);
        for (int i = 0; i < agentInfoList.size(); i++) {
            Logger.info(agentInfoList.get(i).toString());
        }
    }
}
