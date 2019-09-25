package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import lombok.Data;

/**
* <p>
    * ?û??
    * </p>
*
* @author slz
* @since 2019-09-03
*/

    @TableName("guli_user") //  注解指定表名
    @Data public class GuliUser extends Model<GuliUser> {

    @TableId(value = "user_id",type = IdType.AUTO)
    private int userId;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "user_password")
    private String userPassword;

    @TableField(value = "user_phone")
    private String userPhone;

    @TableField(value = "user_email")
    private String userEmail;

    @TableField(value = "user_iamge")
    private String userIamge;

    @TableField(value = "user_auth")
    private int userAuth;

    @TableField(value = "user_real_name")
    private String userRealName;

    @TableField(value = "user_sex")
    private char userSex;

    @TableField(value = "user_actor")
    private String userActor;

    @TableField(value = "user_brief")
    private String userBrief;

    @TableField(value = "user_introduce")
    private String userIntroduce;

    @TableField(value = "user_company")
    private String userCompany;

    @TableField(value = "user_profession")
    private String userProfession;

    @TableField(value = "user_microblog")
    private String userMicroblog;

    @TableField(value = "user_wechat")
    private String userWeChat;

    @TableField(value = "user_qq")
    private String userQQ;

    @TableField(value = "user_personal_space")
    private String userPersonalSpace;


}
