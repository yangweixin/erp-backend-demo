package top.oyoung.erp.controller;

//import org.springframework.data.redis.core.RedisTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;
import top.oyoung.erp.annotation.RegexpValidate;
import top.oyoung.erp.dao.UserDao;
import top.oyoung.erp.entity.User;
import top.oyoung.erp.service.TestService;
import top.oyoung.erp.util.RedisUtil;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @Method: top.oyoung.springbootdemo.controller
 * @Desc:
 * @Author: Yang Weixin
 * @Date: 2018/3/23 13:24
 */
@ApiIgnore
@Controller
@Validated
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private UserDao userDao;

    @ApiOperation("index")
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("param","young");
        modelAndView.addObject("params",new ArrayList<>());
        return modelAndView;
    }

    @PostMapping("/user")
    public void add(
        @RequestBody User user
    ){

    }

    @PutMapping("/user")
    public void put(
        @RequestBody User user
    ){

    }

    @PatchMapping("/user")
    public void patch(
        @RequestBody User user
    ){

    }

    @DeleteMapping("/{id}")
    public void delete(
        @PathVariable("id")Long id
    ){

    }



//    @ApiOperation("获取用户信息")
//    @PreAuthorize("hasRole('NOMAL')")
////    @PostAuthorize("returnObject.account == 'y'")
//    @GetMapping("/{id}")
//    @ResponseBody
//    public User t3(@PathVariable("id")int id){
//        return testService.getById(id);
//    }


    @GetMapping("/{key}/{value}")
    @ResponseBody
    public String t6(@PathVariable("key")String key, @PathVariable("value")String value){
        redisUtil.setValue(key, value);
        return redisUtil.getValue(key).toString();
    }

    @GetMapping("/valid")
    @ResponseBody
    public String valid(
        @Range
        @RegexpValidate(message = "必须数字哦",regexp = "\\d*")
        String name
    ){
        return "name";
    }
}
