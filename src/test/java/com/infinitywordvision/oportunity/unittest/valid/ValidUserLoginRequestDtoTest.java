package com.infinitywordvision.oportunity.unittest.valid;


import com.infinitywordvision.oportunity.dto.request.UserLoginRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@Import(LocalValidatorFactoryBean.class)
public class ValidUserLoginRequestDtoTest {

    @Autowired
    private Validator validator;

    @Test
    void shouldValidUserLoginRequestDto() {
        UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
        Set<ConstraintViolation<UserLoginRequestDto>> violations
                = validator.validate(userLoginRequestDto);
        violations.stream().forEach(e -> System.out.println(e.toString()));
    }



}
