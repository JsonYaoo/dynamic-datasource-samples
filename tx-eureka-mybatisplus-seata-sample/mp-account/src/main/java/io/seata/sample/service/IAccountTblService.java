package io.seata.sample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.seata.sample.entity.AccountTbl;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jsonyao
 * @since 2021-04-27
 */
public interface IAccountTblService extends IService<AccountTbl> {

    void reduce(String userId, int money);

}
