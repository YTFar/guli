package com.guli.pojo.ordervo;

import com.guli.pojo.GuliOrder;
import lombok.Data;
import lombok.ToString;

/**
 * @author 齐天大圣
 * @date 2019/9/7 18:05
 * @package com.guli.pojo.OrderVo
 */
@Data
@ToString
/**
 * 订单与用户集合类
 */
public class OrderAndUser extends GuliOrder {

    private String userName;

    private String userPhone;

    private String  userEmail;

    private String shipper;

    private String shipperId;
}
