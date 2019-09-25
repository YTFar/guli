package com.guli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.pojo.GuliUser;
import com.guli.pojo.ordervo.GuliOrderAndCourseVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * ?û?? Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliUserMapper extends BaseMapper<GuliUser> {

    @Select("SELECT b.user_id,a.order_id,c.course_name,a.order_number,a.order_price,a.order_create_time,a.order_status FROM guli_order a INNER JOIN guli_item b ON a.item_id = b.item_id INNER JOIN guli_course c ON b.course_id = c.course_id WHERE b.user_id = #{userId} AND a.order_status = 0 OR a.order_status = 1")
    public List<GuliOrderAndCourseVo> findAllOrder(int id);

    @Select("SELECT b.user_id,a.order_id,c.course_name,a.order_number,a.order_price,a.order_create_time,a.order_status,a.order_update_time FROM guli_order a INNER JOIN guli_item b ON a.item_id = b.item_id INNER JOIN guli_course c ON b.course_id = c.course_id WHERE b.user_id = #{userId} AND a.order_status = 2")
    public List<GuliOrderAndCourseVo> findAllRefundOrder(int id);

    @Select("SELECT b.user_id,a.order_id,c.course_name,a.order_number,a.order_price,a.order_create_time,a.order_status FROM guli_order a INNER JOIN guli_item b ON a.item_id = b.item_id INNER JOIN guli_course c ON b.course_id = c.course_id WHERE b.user_id = #{userId} AND a.order_status = 2 AND c.course_name LIKE CONCAT('%',#{searchName},'%')")
    public List<GuliOrderAndCourseVo> searchVague(@Param("userId") int userId,@Param("searchName") String searchName);

    @Select("SELECT * FROM guli_user WHERE user_phone = #{userPhone}")
    GuliUser findUserByPhoneNumber(String userPhone);


}
