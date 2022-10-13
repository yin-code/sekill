package com.yxy.seckilldemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxy.seckilldemo.pojo.User;
import com.yxy.seckilldemo.vo.LoginVo;
import com.yxy.seckilldemo.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zhoubin
 * @since 2022-06-06
 */
public interface IUserService extends IService<User> {
    /**
     * 登录
     * @param loginVo
     * @param request
     * @param response
     * @return
     */
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据cookie获取用户
     * @param userTicket
     * @return
     */
    User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response);


}
