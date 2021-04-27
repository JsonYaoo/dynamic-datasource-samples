package com.baomidou.samples.seata.service;

public interface AccountService {

    /**
     * @param userId 用户 ID
     * @param price  扣减金额
     */
    void reduceBalance(Long userId, Double price);

    /**
     * 直接测试账户
     *
     * @param userId
     * @param price
     */
    void testAccount(Long userId, Double price);

}