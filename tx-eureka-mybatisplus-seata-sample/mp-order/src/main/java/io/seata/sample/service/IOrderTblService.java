package io.seata.sample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.seata.sample.entity.OrderTbl;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jsonyao
 * @since 2021-04-27
 */
public interface IOrderTblService extends IService<OrderTbl> {

    void create(String userId, String commodityCode, int count);

}
