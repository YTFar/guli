package com.guli.pojo.concernvo;

import com.guli.pojo.GuliConcern;
import lombok.Data;
import lombok.ToString;

/**
 * @author 齐天大圣
 * @date 2019/9/24 20:11
 * @package com.guli.pojo.concernvo
 */
@Data
@ToString
public class ConcernAndUser extends GuliConcern {
    private String userName;
    private String userPhone;
    private String userEmail;
    private String beFocusedName;//被关注人
    private String attentionName;//关注人
}
