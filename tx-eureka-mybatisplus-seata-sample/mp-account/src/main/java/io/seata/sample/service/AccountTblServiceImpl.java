package io.seata.sample.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.sample.entity.AccountTbl;
import io.seata.sample.mapper.AccountTblMapper;
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
public class AccountTblServiceImpl extends ServiceImpl<AccountTblMapper, AccountTbl> implements IAccountTblService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = {Exception.class})
    public void reduce(String userId, int money) {
        jdbcTemplate.update("update account_tbl set money = money - ? where user_id = ?", new Object[] {money, userId});

        // 测试异常情况
        if(money == 20000) {
            throw new RuntimeException("测试异常情况");
        }
    }
}
