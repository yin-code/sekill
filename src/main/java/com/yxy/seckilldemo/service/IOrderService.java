package com.yxy.seckilldemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxy.seckilldemo.pojo.Order;
import com.yxy.seckilldemo.pojo.User;
import com.yxy.seckilldemo.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2022-06-15
 */
public interface IOrderService extends IService<Order> {
    /**
     * 秒杀
     * @param user
     * @param goods
     */
    Order seckill(User user, GoodsVo goods);

}
