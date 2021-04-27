package com.baomidou.samples.seata.controller;

import com.baomidou.samples.seata.dto.PlaceOrderRequest;
import com.baomidou.samples.seata.service.AccountService;
import com.baomidou.samples.seata.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/testSuccess")
    @ApiOperation("直接测试账户-正常情况")
    public String testSuccess() {
        accountService.testAccount(1L, 1D);
        return "正常情况";
    }

    @PostMapping("/testFail")
    @ApiOperation("直接测试账户-异常情况")
    public String testFail() {
        accountService.testAccount(1L, 2D);
        return "异常情况";
    }
}