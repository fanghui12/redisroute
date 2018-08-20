package com.chanjet.service;

import com.chanjet.entity.PosTrans;
import com.chanjet.mapper.PosTransMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class Tasks1 {
    private static final  Logger Logger = LoggerFactory.getLogger(Tasks1.class);
    public void show(){
        // Logger.info("+++++++++定时任务tasks1打印+++++++++++++");
    }
    @Autowired
    private PosTransMapper postransMapper;
    @Transactional
    public void findtransdetail (Integer rowNum)throws Exception{
        List<PosTrans> list = this.postransMapper.findPosTrans(rowNum);
        for(int i =0;i < list.size();i++) {
            Logger.info(list.get(i).toString());
        }
    }
}
