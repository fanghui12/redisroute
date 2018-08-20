package com.chanjet.mapper;

import com.chanjet.entity.PosTrans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PosTransMapper {
    @Select("select trans_code,trans_date,trans_time,merch_id,term_id,resp_code,resp_desc from b_pos_trans_detail_his where rownum <= #{num}")
    List<PosTrans> findPosTrans(@Param("num") Integer state);
}
