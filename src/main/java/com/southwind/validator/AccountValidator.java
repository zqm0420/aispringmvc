package com.southwind.validator;

/**
 * 基于 Validator 接口的数据校验器
 */

import com.southwind.entity.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AccountValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Account.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username", null, "姓名不能为空");
        ValidationUtils.rejectIfEmpty(errors, "password", null, "密码不能为空");

    }
}
