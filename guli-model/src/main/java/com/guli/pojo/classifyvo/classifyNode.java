package com.guli.pojo.classifyvo;

import com.guli.pojo.GuliClassify;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 齐天大圣
 * @date 2019/9/18 21:00
 * @package com.guli.pojo.classifyvo
 */
@Data
@ToString
public class classifyNode extends GuliClassify {
    private String title;
    List<GuliClassify> children;
}
