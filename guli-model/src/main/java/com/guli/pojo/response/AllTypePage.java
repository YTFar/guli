package com.guli.pojo.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 齐天大圣
 * @date 2019/9/10 22:37
 * @package com.guli.pojo.response
 * 所有分页返回类
 */
@Data
@ToString
public class AllTypePage<T> {

    //当前页数
    private int pageNo;

    //显示的数据量
    private int pageSize;

    //总数据量
    private int pageTotal;

    //显示的数据
    private List<T> pageList;
}
