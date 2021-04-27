package io.seata.sample.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.seata.sample.entity.AccountTbl;
import io.seata.sample.service.IAccountTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jsonyao
 * @since 2021-04-27
 */
@RestController
@RequestMapping("/account")
public class AccountTblController {

    @Autowired
    private IAccountTblService iAccountTblService;

    @RequestMapping(value = "/reduce", produces = "application/json")
    public Boolean debit(String userId, Integer money) {
        iAccountTblService.reduce(userId, money);
        return true;
    }

    /**
    * 获取
    * @param id
    */
    @RequestMapping("/get")
    public AccountTbl get(Long id) {
        Assert.notNull(id, "id不能为空");
        return iAccountTblService.getById(id);
    }

    /**
    * 新增
    * @param accountTbl
    */
    @PostMapping("/add")
    public void add(@RequestBody AccountTbl accountTbl) {
        iAccountTblService.save(accountTbl);
    }
    
    /**
    * 删除
    * @param id
    */
    @RequestMapping("/delete")
    public void delete(Long id) {
        Assert.notNull(id, "id不能为空");
        iAccountTblService.removeById(id);
    }

    /**
    * 修改
    * @param accountTbl
    */
    @PostMapping("/modify")
    public void modify(@RequestBody AccountTbl accountTbl) {
        iAccountTblService.updateById(accountTbl);
    }

    /**
    * 分页查询
    * @param accountTbl
    * @param pageNum
    * @param pageSize
    * @return
    */
    @RequestMapping("/listPage")
    public PageInfo<AccountTbl> listPage(AccountTbl accountTbl, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<AccountTbl> wrapper = new QueryWrapper<AccountTbl>(accountTbl);
        return new PageInfo<AccountTbl>(iAccountTblService.list(wrapper));
    }

    /**
    * 查询所有
    * @return
    */
    @RequestMapping("/listAll")
    public List<AccountTbl> listAll() { 
        return iAccountTblService.list();
    }
 
}
