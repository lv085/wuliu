package com.wuliu.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliu.dao.TranDao;
import com.wuliu.entity.Tran;
import com.wuliu.service.TranService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TranServiceImpl implements TranService {

    @Resource
    private TranDao tranDao;

    public List<Tran> findTranList(int currentPage, int pageSize, String tran_name) {
        PageHelper.startPage(currentPage, pageSize);
        return tranDao.findTranList(tran_name);
    }

    @Override
    public int saveTran(Tran tran) {
        tran.setTran_state(1);
        return tranDao.saveTran(tran);
    }

    @Override
    public Tran findTranById(int tran_id) {
        return tranDao.findTranById(tran_id);
    }

    @Override
    public int updateTran(Tran tran) {
        return tranDao.updateTran(tran);
    }

    @Override
    public int deleteTran(int tran_id) {
        return tranDao.deleteTran(tran_id);
    }

    @Override
    public Tran checkTranName(String tran_name) {
        return tranDao.checkTranName(tran_name);
    }
}
