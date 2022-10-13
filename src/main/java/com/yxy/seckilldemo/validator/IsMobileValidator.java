package com.yxy.seckilldemo.validator;

import com.yxy.seckilldemo.utils.validatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号码校验规则
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {

    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required){
            return validatorUtil.isMobile(value);
        }else{
            if(StringUtils.isEmpty(value)){
                return true;
            }else{
                return validatorUtil.isMobile(value);
            }
        }
    }
}
