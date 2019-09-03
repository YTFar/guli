package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * ?û???Ϣ?
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliInfo extends Model<GuliInfo> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "info_id", type = IdType.AUTO)
    private Long infoId;

    private Long userId;

    private String infoRealName;

    private String infoSex;

    private String infoActor;

    private String infoBrief;

    private String infoIntroduce;

    private String infoCompany;

    private String infoProfession;

    private String infoMicroblog;

    private String infoWechat;

    private String infoQq;

        public Long getInfoId() {
        return infoId;
        }

            public void setInfoId(Long infoId) {
        this.infoId = infoId;
        }
        public Long getUserId() {
        return userId;
        }

            public void setUserId(Long userId) {
        this.userId = userId;
        }
        public String getInfoRealName() {
        return infoRealName;
        }

            public void setInfoRealName(String infoRealName) {
        this.infoRealName = infoRealName;
        }
        public String getInfoSex() {
        return infoSex;
        }

            public void setInfoSex(String infoSex) {
        this.infoSex = infoSex;
        }
        public String getInfoActor() {
        return infoActor;
        }

            public void setInfoActor(String infoActor) {
        this.infoActor = infoActor;
        }
        public String getInfoBrief() {
        return infoBrief;
        }

            public void setInfoBrief(String infoBrief) {
        this.infoBrief = infoBrief;
        }
        public String getInfoIntroduce() {
        return infoIntroduce;
        }

            public void setInfoIntroduce(String infoIntroduce) {
        this.infoIntroduce = infoIntroduce;
        }
        public String getInfoCompany() {
        return infoCompany;
        }

            public void setInfoCompany(String infoCompany) {
        this.infoCompany = infoCompany;
        }
        public String getInfoProfession() {
        return infoProfession;
        }

            public void setInfoProfession(String infoProfession) {
        this.infoProfession = infoProfession;
        }
        public String getInfoMicroblog() {
        return infoMicroblog;
        }

            public void setInfoMicroblog(String infoMicroblog) {
        this.infoMicroblog = infoMicroblog;
        }
        public String getInfoWechat() {
        return infoWechat;
        }

            public void setInfoWechat(String infoWechat) {
        this.infoWechat = infoWechat;
        }
        public String getInfoQq() {
        return infoQq;
        }

            public void setInfoQq(String infoQq) {
        this.infoQq = infoQq;
        }

    @Override
    protected Serializable pkVal() {
        return this.infoId;
    }

    @Override
    public String toString() {
    return "GuliInfo{" +
            "infoId=" + infoId +
            ", userId=" + userId +
            ", infoRealName=" + infoRealName +
            ", infoSex=" + infoSex +
            ", infoActor=" + infoActor +
            ", infoBrief=" + infoBrief +
            ", infoIntroduce=" + infoIntroduce +
            ", infoCompany=" + infoCompany +
            ", infoProfession=" + infoProfession +
            ", infoMicroblog=" + infoMicroblog +
            ", infoWechat=" + infoWechat +
            ", infoQq=" + infoQq +
    "}";
    }
}
