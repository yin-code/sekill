package com.yxy.seckilldemo.controller;

import com.yxy.seckilldemo.service.IUserService;
import com.yxy.seckilldemo.vo.LoginVo;
import com.yxy.seckilldemo.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequestMapping("/login")
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 跳转
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 功能描述：登录功能
     * @param loginVo
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        return userService.doLogin(loginVo,request,response);
    }
}
