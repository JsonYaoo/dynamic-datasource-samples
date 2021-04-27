package io.seata.sample.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.seata.sample.entity.OrderTbl;
import io.seata.sample.service.IOrderTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/order")
public class OrderTblController {

    @Autowired
    private IOrderTblService iOrderTblService;

    @GetMapping(value = "/create", produces = "application/json")
    public Boolean create(String userId, String commodityCode, int count) {
        iOrderTblService.create(userId, commodityCode, count);
        return true;
    }

    /**
    * 获取
    * @param id
    */
    @RequestMapping("/get")
    public OrderTbl get(Long id) {
        Assert.notNull(id, "id不能为空");
        return iOrderTblService.getById(id);
    }

    /**
    * 新增
    * @param orderTbl
    */
    @PostMapping("/add")
    public void add(@RequestBody OrderTbl orderTbl) {
        iOrderTblService.save(orderTbl);
    }
    
    /**
    * 删除
    * @param id
    */
    @RequestMapping("/delete")
    public void delete(Long id) {
        Assert.notNull(id, "id不能为空");
        iOrderTblService.removeById(id);
    }

    /**
    * 修改
    * @param orderTbl
    */
    @PostMapping("/modify")
    public void modify(@RequestBody OrderTbl orderTbl) {
        iOrderTblService.updateById(orderTbl);
    }

    /**
    * 分页查询
    * @param orderTbl
    * @param pageNum
    * @param pageSize
    * @return
    */
    @RequestMapping("/listPage")
    public PageInfo<OrderTbl> listPage(OrderTbl orderTbl, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<OrderTbl> wrapper = new QueryWrapper<OrderTbl>(orderTbl);
        return new PageInfo<OrderTbl>(iOrderTblService.list(wrapper));
    }

    /**
    * 查询所有
    * @return
    */
    @RequestMapping("/listAll")
    public List<OrderTbl> listAll() { 
        return iOrderTblService.list();
    }
 
}
