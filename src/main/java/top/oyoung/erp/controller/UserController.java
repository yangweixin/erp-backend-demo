package top.oyoung.erp.controller;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.oyoung.erp.constants.Constants;
import top.oyoung.erp.entity.User;
import top.oyoung.erp.entity.UserRole;
import top.oyoung.erp.entity.in.UserParam;
import top.oyoung.erp.entity.out.TokenResult;
import top.oyoung.erp.entity.out.UserResult;
import top.oyoung.erp.exception.UserException;
import top.oyoung.erp.service.UserService;
import top.oyoung.erp.util.JwtUtil;
import top.oyoung.erp.util.SHAUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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
    public TokenResult login(
        @Valid @RequestBody UserParam userParam
    ){
        User user = userService.getUserByName( userParam.getUsername() );
        if(user == null){
            throw new UserException.UserNotFoundException();
        }

        if( !user.getPassword().equals( SHAUtil.encode( userParam.getPassword(), user.getSalt() ) ) ){
            throw new UserException.PasswordErrorException();
        }

        String token = jwtUtil.generateToken( user );

        return new TokenResult(Constants.AUTHORIZATION_HEADER + token);
    }

    @PreAuthorize("hasAuthority('ROLE_DEVELOPER')")
    @GetMapping("{id:[1-9]\\d*}")
    public UserResult getUser(@PathVariable("id")Long id){
        User user = userService.getUserById(id);
        return new UserResult(user.getId(), user.getUsername(), user.getAddress(), (List<GrantedAuthority>)user.getAuthorities());
    }

    @GetMapping("")
    public UserResult getSelf(){
        User user =  (User)SecurityContextHolder.getContext().getAuthentication().getDetails();

        return new UserResult(user.getId(), user.getUsername(), user.getAddress(), (List<GrantedAuthority>)user.getAuthorities());
    }

    @PostMapping("registe")
    @ResponseStatus(HttpStatus.CREATED)
    public void registe(
        @Valid @RequestBody UserParam userParam
    ){
        String salt = UUID.randomUUID().toString().substring(0,7);
        String encode = SHAUtil.encode(userParam.getPassword(), salt);
        User user = new User();
        user.setUsername(userParam.getUsername());
        user.setPassword(encode);
        user.setSalt(salt);
        if (userService.insertUser(user) == 1){
            UserRole userRole = new UserRole(user.getId(), 1);
            userService.addRole(userRole);
        }
    }
}
