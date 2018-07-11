package top.oyoung.erp.annotation;

import top.oyoung.erp.validator.RegexpValidator;
import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RegexpValidator.class})
public @interface RegexpValidate {
    String message() default "RegexpValidate";
    String regexp();
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
