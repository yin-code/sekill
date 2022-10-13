package com.yxy.seckilldemo.vo;

import com.yxy.seckilldemo.validator.IsMobile;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoginVo {
    @NotNull
    @IsMobile
    private String mobile;
    @NotNull
    @Length(min=32)
    private String password;


}
