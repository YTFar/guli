package com.guli.service;

import com.guli.pojo.GuliClassify;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.pojo.classifyvo.classifyNode;

import java.util.List;

/**
 * <p>
 * ????? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliClassifyService extends IService<GuliClassify> {

    List<classifyNode> findAllClassifyNode();

    int addClassify(GuliClassify guliClassify);
}
