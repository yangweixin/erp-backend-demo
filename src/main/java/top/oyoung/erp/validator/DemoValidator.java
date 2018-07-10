package top.oyoung.erp.validator;

import org.springframework.util.StringUtils;
import top.oyoung.erp.annotation.MyGate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DemoValidator implements ConstraintValidator<MyGate,String> {

    private String regexp;
    private String message;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValied = false;

        if(StringUtils.isEmpty(value)){
            message = "不能为空";
        }
        if(StringUtils.isEmpty(regexp)){
            message = "正则不能为空";
        }

        if(value.matches(regexp)){
            isValied = true;
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        return isValied;
    }

    @Override
    public void initialize(MyGate constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
        this.message = constraintAnnotation.message();
    }
}
