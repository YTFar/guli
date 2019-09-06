package com.guli.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guli.mapper.GuliClassifyMapper;
import com.guli.pojo.GuliClassify;
import com.guli.product.service.GuliClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ????? 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-02
 */
@Service
public class GuliClassifyServiceImpl extends ServiceImpl<GuliClassifyMapper, GuliClassify> implements GuliClassifyService {

    @Autowired
    private GuliClassifyMapper guliClassifyMapper;

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    RedisUtil redisUtil;

    @Override
    public IPage<GuliClassify> fenYe(Page page) {

//        IPage<GuliClassify> easybuyNewsIPage = guliClassifyMapper.selectPageVo(page);
//        return easybuyNewsIPage;
        System.out.println("------------------------------------------");
        System.out.println("1111111111111111111111111111111111111111111");
        System.out.println("------------------------------------------");
        //从缓存中查询当前对象
//        redisUtil.get("ls");
        IPage<GuliClassify> page1 = (IPage<GuliClassify>)redisTemplate.opsForValue().get("page");
        //没有取到
        if(page1 == null){
            System.out.println("1");
            //从数据库中查询
            page1 = this.page(page);
            //存到缓存当中
            redisTemplate.opsForValue().set("page",page1);
        }
//        IPage<GuliClassify> easybuyNewsIPage = guliClassifyMapper.selectPageVo(page);
        return page1;
    }

    @Override
    public IPage<GuliClassify> fenYe2(Page page) {
        System.out.println("------------------------------------------");
        System.out.println("222222222222222222222222222222222222222222");
        System.out.println("------------------------------------------");
        //从缓存中查询当前对象
        IPage<GuliClassify> page1 = (IPage<GuliClassify>)redisTemplate.opsForValue().get("page");
        //没有取到
        if(page1 == null){
            System.out.println("2");
            //从数据库中查询
            page1 = guliClassifyMapper.selectPageVo(page);
            //存到缓存当中
            redisTemplate.opsForValue().set("page",page1);
        }
//        IPage<GuliClassify> easybuyNewsIPage = guliClassifyMapper.selectPageVo(page);
        return page1;
    }
}
