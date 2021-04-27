package io.seata.sample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.sample.entity.OrderTbl;
import io.seata.sample.feign.UserFeignClient;
import io.seata.sample.mapper.OrderTblMapper;
import io.seata.sample.service.IOrderTblService;
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
public class OrderTblServiceImpl extends ServiceImpl<OrderTblMapper, OrderTbl> implements IOrderTblService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = {Exception.class})
    public void create(String userId, String commodityCode, int count) {
        int orderMoney = count * 100;
        jdbcTemplate.update("insert order_tbl(user_id,commodity_code,count,money) values(?,?,?,?)",
                new Object[] {userId, commodityCode, count, orderMoney});

        if(count == 300) {
            throw new RuntimeException("测试异常情况");
        }

        userFeignClient.reduce(userId, orderMoney);
    }
}
