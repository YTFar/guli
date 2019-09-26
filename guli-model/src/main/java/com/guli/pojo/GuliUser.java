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

    @TableField("user_phone")
    private String userPhone;

    @TableField("user_email")
    private String userEmail;

    @TableField("user_image")
    private String userIamge;

    private String userRealName;

    private String userSex;

    private String userActor;

    private String userBrief;

    private String userIntroduce;

    private String userCompany;

    private String userMicroblog;

    private String userWechat;

    private String userQq;

            /**
            * 0 用戶 1 教师 2 管理员
            */
            @TableField("user_auth")
    private Integer userAuth;

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserActor() {
        return userActor;
    }

    public void setUserActor(String userActor) {
        this.userActor = userActor;
    }

    public String getUserBrief() {
        return userBrief;
    }

    public void setUserBrief(String userBrief) {
        this.userBrief = userBrief;
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    public String getUserMicroblog() {
        return userMicroblog;
    }

    public void setUserMicroblog(String userMicroblog) {
        this.userMicroblog = userMicroblog;
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    @TableField(value = "user_wechat")
    private String userWeChat;

    @TableField(value = "user_qq")
    private String userQQ;

    @TableField(value = "user_personal_space")
    private String userPersonalSpace;


    @Override
    public String toString() {
        return "GuliUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userIamge='" + userIamge + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userActor='" + userActor + '\'' +
                ", userBrief='" + userBrief + '\'' +
                ", userIntroduce='" + userIntroduce + '\'' +
                ", userCompany='" + userCompany + '\'' +
                ", userMicroblog='" + userMicroblog + '\'' +
                ", userWechat='" + userWechat + '\'' +
                ", userQq='" + userQq + '\'' +
                ", userAuth=" + userAuth +
                '}';
    }
}
