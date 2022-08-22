package com.wuliu.service;

import com.wuliu.entity.Tran;

import java.util.List;

public interface TranService {
    List<Tran> findTranList(int currentPage, int pageSize, String tran_name);

    int saveTran(Tran tran);

    Tran findTranById(int tran_id);

    int updateTran(Tran tran);

    int deleteTran(int tran_id);

    Tran checkTranName(String tran_name);
}
