package com.yxy.seckilldemo.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yxy.seckilldemo.pojo.User;
import com.yxy.seckilldemo.service.IGoodsService;
import com.yxy.seckilldemo.service.IUserService;
import com.yxy.seckilldemo.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodsService goodsService;
    /**
     * 跳转商品列表页
     * @param
     * @param model
     * @param
     * @return
     */
    @RequestMapping("/toList")
    public String toList(Model model,User user){
        //if (StringUtils.isEmpty(ticket)){
        //    return "login";
        //}
        //User user =(User) session.getAttribute(ticket);

        //User user = userService.getUserByCookie(ticket,request,reponse);
        //if(null ==user){
         //   return "login";
        //}
        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());


        return "goodsList";
    }

    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId) {
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goods);

        Date startDate = goods.getStartDate();
        Date endDate = goods.getEndDate();
        Date nowDate = new Date();
        //秒杀状态
        int secKillStatus = 0;
        //剩余开始时间
        int remainSeconds = 0;
        //秒杀还未开始
        if (nowDate.before(startDate)) {
            remainSeconds = (int) ((startDate.getTime()-nowDate.getTime())/1000);
            // 秒杀已结束
        } else if (nowDate.after(endDate)) {
            secKillStatus = 2;
            remainSeconds = -1;
            // 秒杀中
        } else {
            secKillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("secKillStatus",secKillStatus);
        model.addAttribute("remainSeconds",remainSeconds);

        return "goodsDetail";
    }

}
