package com.guli.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* <p>
    * ?????
    * </p>
*
* @author slz
* @since 2019-09-02
*/
public class GuliClassify extends Model<GuliClassify> implements Serializable{

    private static final long serialVersionUID = 1L;

            @TableId(value = "classify_id", type = IdType.AUTO)
    private Long classifyId;

    private String classifyName;

    private Long parentId;

        public Long getClassifyId() {
        return classifyId;
        }

            public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
        }
        public String getClassifyName() {
        return classifyName;
        }

            public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
        }
        public Long getParentId() {
        return parentId;
        }

            public void setParentId(Long parentId) {
        this.parentId = parentId;
        }

    @Override
    protected Serializable pkVal() {
        return this.classifyId;
    }

    @Override
    public String toString() {
    return "GuliClassify{" +
            "classifyId=" + classifyId +
            ", classifyName=" + classifyName +
            ", parentId=" + parentId +
    "}";
    }
}
