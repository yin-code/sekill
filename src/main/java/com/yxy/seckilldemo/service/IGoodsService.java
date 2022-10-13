package com.yxy.seckilldemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxy.seckilldemo.pojo.Goods;
import com.yxy.seckilldemo.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2022-06-15
 */
public interface IGoodsService extends IService<Goods> {


    /*
    获取商品列表
     */
    List<GoodsVo> findGoodsVo();

    /**
     * 跳转详情页
     * @param goodsId
     * @return
     */
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
