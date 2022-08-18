package com.wuliu.dao;

import com.wuliu.entity.Tran;

import java.util.List;

public interface TranDao {
    List<Tran> findTranList(String tran_name);

    int saveTran(Tran tran);

    Tran findTranById(int tran_id);

    int updateTran(Tran tran);

    int deleteTran(int tran_id);

    Tran checkTranName(String tran_name);
}
