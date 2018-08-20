package com.chanjet.mapper;

import com.chanjet.entity.AgentInfo;
import com.chanjet.entity.PosTrans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AgentMapper {
    @Select("select agent_id,agent_name,zmk from b_agent where rownum <= #{num}")
    List<AgentInfo> findAgentinfo(@Param("num") Integer state);
}
