package com.lc.admin.web.controller;

import com.lc.admin.entity.User;
import com.lc.admin.service.UserService;
import com.lc.admin.utils.ResultResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth liuchong
 * @data 2019-07-04 9:55
 **/
@Api(tags = "用户", description = "用户信息")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户列表")
    @RequestMapping(value = "/listpage",method = RequestMethod.GET)
    public ResultResp<Page<User>> list(@ApiParam(value = "页码",defaultValue = "1") @RequestParam(defaultValue = "1") int page,
                                       @ApiParam(value = "条数",defaultValue = "20") @RequestParam(required = false,defaultValue = "20") int size){
        return ResultResp.ok(userService.list(page,size));
    }


    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultResp add(@ApiParam(value = "用户信息")User user){
        userService.save(user);
        return ResultResp.ok();
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/remove",method = RequestMethod.GET)
    public ResultResp remove(@ApiParam(value = "用户id")@RequestParam Long id){
        userService.remove(id);
        return ResultResp.ok();
    }

    @ApiOperation(value = "批量删除用户")
    @RequestMapping(value = "/batchremove",method = RequestMethod.GET)
    public ResultResp batchRemove(@ApiParam(value = "用户id")@RequestParam Long[] ids){
        userService.batchRemove(ids);
        return ResultResp.ok();
    }

    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResultResp edit(@ApiParam(value = "用户信息")User user){
        userService.update(user);
        return ResultResp.ok();
    }


}
