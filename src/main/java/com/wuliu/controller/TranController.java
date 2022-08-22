package com.wuliu.controller;

import com.wuliu.entity.Tran;
import com.wuliu.service.TranService;
import com.wuliu.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/TranController")
public class TranController {

    @Resource
    private TranService tranService;

    @GetMapping("/findTranList")
    public Result findTranList(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
            @RequestParam(value = "tran_name", defaultValue = "") String tran_name) {
        List<Tran> tranList = tranService.findTranList(currentPage, pageSize, tran_name);
        PageInfo pageInfo = new PageInfo(tranList);
        return Result.success(pageInfo, "查询成功");
    }

    @PostMapping("/saveTran")
    public Result saveTran(@RequestBody Tran tran) {
        if (tran.getTran_name() == null || tran.getTran_money() == 0) {
            return Result.error("添加失败");
        } else {
            if (tranService.checkTranName(tran.getTran_name()) != null) {
                return Result.error("添加失败");
            } else {
                int i = tranService.saveTran(tran);
                if (i > 0) {
                    return Result.success("添加成功");
                } else {
                    return Result.error("添加失败");
                }
            }
        }
    }

    @GetMapping("/findTranById")
    public Result findTranById(@RequestParam(value = "tran_id") int tran_id) {
        Tran tran = tranService.findTranById(tran_id);
        if (null != tran) {
            return Result.success(tran, "查询成功");
        }
        return Result.error("查询失败");
    }

    @PutMapping("/updateTran")
    public Result updateTran(@RequestBody Tran tran) {
        int i = tranService.updateTran(tran);
        if (i > 0) {
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    @DeleteMapping("/deleteTran")
    public Result deleteTran(@RequestParam(value = "tran_id") int tran_id) {
        int i = tranService.deleteTran(tran_id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }


}
