package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import java.util.Date;

/**
* <p>
    * ?????
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliItem extends Model<GuliItem> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "item_id", type = IdType.AUTO)
    private Long itemId;

    private Long userId;

    private Long courseId;

    private Date affiliate_time;

    public Date getAffiliate_time() {
        return affiliate_time;
    }

    @Override
    public String toString() {
        return "GuliItem{" +
                "itemId=" + itemId +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", affiliate_time=" + affiliate_time +
                ", courseCollect=" + courseCollect +
                ", courseAffiliate=" + courseAffiliate +
                '}';
    }

    public void setAffiliate_time(Date affiliate_time) {
        this.affiliate_time = affiliate_time;
    }

    /**
            * no 0 yes 1
            */
    private Integer courseCollect;

            /**
            * no 0 yes 1
            */
    private Integer courseAffiliate;

        public Long getItemId() {
        return itemId;
        }

            public void setItemId(Long itemId) {
        this.itemId = itemId;
        }
        public Long getUserId() {
        return userId;
        }

            public void setUserId(Long userId) {
        this.userId = userId;
        }
        public Long getCourseId() {
        return courseId;
        }

            public void setCourseId(Long courseId) {
        this.courseId = courseId;
        }
        public Integer getCourseCollect() {
        return courseCollect;
        }

            public void setCourseCollect(Integer courseCollect) {
        this.courseCollect = courseCollect;
        }
        public Integer getCourseAffiliate() {
        return courseAffiliate;
        }

            public void setCourseAffiliate(Integer courseAffiliate) {
        this.courseAffiliate = courseAffiliate;
        }

    @Override
    protected Serializable pkVal() {
        return this.itemId;
    }

}
