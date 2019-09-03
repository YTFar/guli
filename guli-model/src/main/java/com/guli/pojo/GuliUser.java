package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * ?û??
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliUser extends Model<GuliUser> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    private String userName;

    private String userPassword;

    private String userPhone;

    private String userEmail;

    private String userIamge;

            /**
            * 0 用戶 1 教师 2 管理员
            */
    private Integer userAuth;

        public Long getUserId() {
        return userId;
        }

            public void setUserId(Long userId) {
        this.userId = userId;
        }
        public String getUserName() {
        return userName;
        }

            public void setUserName(String userName) {
        this.userName = userName;
        }
        public String getUserPassword() {
        return userPassword;
        }

            public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        }
        public String getUserPhone() {
        return userPhone;
        }

            public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
        }
        public String getUserEmail() {
        return userEmail;
        }

            public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        }
        public String getUserIamge() {
        return userIamge;
        }

            public void setUserIamge(String userIamge) {
        this.userIamge = userIamge;
        }
        public Integer getUserAuth() {
        return userAuth;
        }

            public void setUserAuth(Integer userAuth) {
        this.userAuth = userAuth;
        }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
    return "GuliUser{" +
            "userId=" + userId +
            ", userName=" + userName +
            ", userPassword=" + userPassword +
            ", userPhone=" + userPhone +
            ", userEmail=" + userEmail +
            ", userIamge=" + userIamge +
            ", userAuth=" + userAuth +
    "}";
    }
}
