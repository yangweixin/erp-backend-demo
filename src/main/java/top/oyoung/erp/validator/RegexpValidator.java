package top.oyoung.erp.validator;

import org.springframework.util.StringUtils;
import top.oyoung.erp.annotation.RegexpValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexpValidator implements ConstraintValidator<RegexpValidate,String> {

    private String regexp;
    private String message;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValied = false;

        if(StringUtils.isEmpty(value)){
            message = "待校验内容为空";
        }
        if(StringUtils.isEmpty(regexp)){
            message = "正则表达式为空";
        }

        if(isValied && value.matches(regexp)){
            isValied = true;
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        return isValied;
    }

    @Override
    public void initialize(RegexpValidate constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
        this.message = constraintAnnotation.message();
    }
}
