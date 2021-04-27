package io.seata.sample.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.seata.sample.entity.StorageTbl;
import io.seata.sample.service.IStorageTblService;
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
@RequestMapping("/storage")
public class StorageTblController {

    @Autowired
    private IStorageTblService iStorageTblService;

    @RequestMapping(value = "/deduct", produces = "application/json")
    public Boolean deduct(String commodityCode, int count) {
        iStorageTblService.deduct(commodityCode, count);
        return true;
    }

    /**
    * 获取
    * @param id
    */
    @RequestMapping("/get")
    public StorageTbl get(Long id) {
        Assert.notNull(id, "id不能为空");
        return iStorageTblService.getById(id);
    }

    /**
    * 新增
    * @param storageTbl
    */
    @PostMapping("/add")
    public void add(@RequestBody StorageTbl storageTbl) {
        iStorageTblService.save(storageTbl);
    }
    
    /**
    * 删除
    * @param id
    */
    @RequestMapping("/delete")
    public void delete(Long id) {
        Assert.notNull(id, "id不能为空");
        iStorageTblService.removeById(id);
    }

    /**
    * 修改
    * @param storageTbl
    */
    @PostMapping("/modify")
    public void modify(@RequestBody StorageTbl storageTbl) {
        iStorageTblService.updateById(storageTbl);
    }

    /**
    * 分页查询
    * @param storageTbl
    * @param pageNum
    * @param pageSize
    * @return
    */
    @RequestMapping("/listPage")
    public PageInfo<StorageTbl> listPage(StorageTbl storageTbl, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<StorageTbl> wrapper = new QueryWrapper<StorageTbl>(storageTbl);
        return new PageInfo<StorageTbl>(iStorageTblService.list(wrapper));
    }

    /**
    * 查询所有
    * @return
    */
    @RequestMapping("/listAll")
    public List<StorageTbl> listAll() { 
        return iStorageTblService.list();
    }
 
}
