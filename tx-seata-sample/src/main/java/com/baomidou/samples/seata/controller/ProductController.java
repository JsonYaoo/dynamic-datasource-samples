package com.baomidou.samples.seata.controller;

import com.baomidou.samples.seata.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/testSuccess")
    @ApiOperation("直接测试产品-正常情况")
    public String testSuccess() {
        productService.testProduct(1L, 1);
        return "正常情况";
    }

    @PostMapping("/testFail")
    @ApiOperation("直接测试产品-异常情况")
    public String testFail() {
        productService.testProduct(1L, 2);
        return "异常情况";
    }
}