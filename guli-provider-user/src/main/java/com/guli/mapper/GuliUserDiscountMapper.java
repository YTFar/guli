package com.guli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.pojo.GuliReceive;
import com.guli.pojo.ordervo.GuliDiscountVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GuliUserDiscountMapper extends BaseMapper<GuliReceive> {

    @Select("SELECT r.receive_id,r.discount_id,d.discount_name,d.discount_price,r.receive_create_time,d.discont_end_time,r.receive_status,r.user_id FROM guli_discount d INNER JOIN guli_receive r ON d.discount_id = r.discount_id WHERE r.user_id = #{userId}")
    public List<GuliDiscountVo> findAllUserDiscount(int userId);

    @Select("SELECT r.receive_id,r.discount_id,d.discount_name,d.discount_price,r.receive_create_time,d.discont_end_time,r.receive_status,r.user_id FROM guli_discount d INNER JOIN guli_receive r ON d.discount_id = r.discount_id WHERE r.receive_status = 0 AND WHERE r.user_id = #{userId}")
    public List<GuliDiscountVo> findAllUserCardUseAble(int userId);

    @Select("SELECT r.receive_id,r.discount_id,d.discount_name,d.discount_price,r.receive_create_time,d.discont_end_time,r.receive_status,r.user_id FROM guli_discount d INNER JOIN guli_receive r ON d.discount_id = r.discount_id WHERE r.receive_status = 1 AND WHERE r.user_id = #{userId}")
    public List<GuliDiscountVo> findAllUserCardUsed(int userId);

    @Select("SELECT r.receive_id,r.discount_id,d.discount_name,d.discount_price,r.receive_create_time,d.discont_end_time,r.receive_status,r.user_id FROM guli_discount d INNER JOIN guli_receive r ON d.discount_id = r.discount_id WHERE r.receive_status = 2 AND WHERE r.user_id = #{userId}")
    public List<GuliDiscountVo> findAllUserCardOutDate(int userId);


}
