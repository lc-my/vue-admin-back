package com.lc.admin.web.controller;

import com.lc.admin.entity.User;
import com.lc.admin.service.UserService;
import com.lc.admin.utils.ResultResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登陆
 *
 * @auth liuchong
 * @data 2019-07-03 11:22
 **/
@Api(tags = "用户", description = "用户信息")
@RestController
@RequestMapping("/")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登陆")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResultResp login(@ApiParam(value = "用户名称", required = true) @RequestParam String userName,
                            @ApiParam(value = "用户密码", required = true)  @RequestParam String password) {
        User user = userService.findByUserNameAndPassword(userName,password);
        if(user != null){
            return ResultResp.ok(user);
        }
        return ResultResp.fail("用户名或密码错误");
    }

}
