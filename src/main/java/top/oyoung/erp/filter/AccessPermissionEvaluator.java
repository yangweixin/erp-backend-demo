package top.oyoung.erp.filter;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import top.oyoung.erp.Constants.Constants;

import java.io.Serializable;

@Component
public class AccessPermissionEvaluator
    implements PermissionEvaluator{

    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {

        if(target.equals(authentication.getName())){
            for (GrantedAuthority author : authentication.getAuthorities()) {
                if(author.getAuthority().equals(Constants.SECURITY_ROLE_PREFIX+ permission)){
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
