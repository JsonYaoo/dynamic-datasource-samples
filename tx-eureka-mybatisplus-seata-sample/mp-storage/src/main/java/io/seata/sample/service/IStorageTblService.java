package io.seata.sample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.seata.sample.entity.StorageTbl;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jsonyao
 * @since 2021-04-27
 */
public interface IStorageTblService extends IService<StorageTbl> {

    void deduct(String commodityCode, int count);

}
