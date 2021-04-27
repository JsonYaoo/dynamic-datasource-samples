package io.seata.sample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.sample.entity.StorageTbl;
import io.seata.sample.mapper.StorageTblMapper;
import io.seata.sample.service.IStorageTblService;
import io.seata.spring.annotation.GlobalLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jsonyao
 * @since 2021-04-27
 */
@Service
public class StorageTblServiceImpl extends ServiceImpl<StorageTblMapper, StorageTbl> implements IStorageTblService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GlobalLock
    @Transactional(rollbackFor = {Exception.class})
    public void deduct(String commodityCode, int count) {
        jdbcTemplate.update("update storage_tbl set count = count - ? where commodity_code = ?",
                new Object[] {count, commodityCode});

        // 测试异常情况
        if(count == 200) {
            throw new RuntimeException("测试异常情况");
        }
    }
}
