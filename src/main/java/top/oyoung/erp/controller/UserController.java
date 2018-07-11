package top.oyoung.erp.controller;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.oyoung.erp.Constants.Constants;
import top.oyoung.erp.Constants.ErrorCode;
import top.oyoung.erp.entity.User;
import top.oyoung.erp.entity.in.UserParam;
import top.oyoung.erp.entity.out.UserResult;
import top.oyoung.erp.exception.LocalException;
import top.oyoung.erp.exception.UserException;
import top.oyoung.erp.service.UserService;
import top.oyoung.erp.util.JwtUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/11 上午11:41
 */

@Api(tags = "User", description = "用户模块")
@Validated
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private JwtUtil jwtUtil;

    @PostMapping("login")
    public String login(
        @Valid @RequestBody UserParam userParam
    ){
        User user = userService.getUserByName( userParam.getUsername() );
        if(user == null){
            throw new UserException.UserNotFoundException();
        }
        if( !userParam.getPassword().equals( user.getPassword() ) ){
            throw new UserException.PasswordErrorException();
        }

        String token = jwtUtil.generateToken( user );

        return Constants.AUTHORIZATION_HEADER + token;
    }

    @GetMapping("{id:[1-9]\\d*}")
    public User getUser(@PathVariable("id")Long id){
        return userService.getUserById(id);
    }

    @GetMapping("")
    public UserResult getSelf(){
        User user =  (User)SecurityContextHolder.getContext().getAuthentication().getDetails();

        return new UserResult(user.getId(), user.getUsername(), user.getAddress(), (List<GrantedAuthority>)user.getAuthorities());
    }

}
