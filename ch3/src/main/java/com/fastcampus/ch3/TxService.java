package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxService {
    @Autowired A1Dao a1Dao;
    @Autowired B1Dao b1Dao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertA1WithTx() throws Exception {
        a1Dao.insert(1, 100);       // 성공
        insertB1WithTx();
        a1Dao.insert(1, 200);       // 실패
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,  rollbackFor = Exception.class)
    public void insertB1WithTx() throws Exception {
        b1Dao.insert(1, 100);       // 성공
        b1Dao.insert(2, 200);       // 성공
    }

    public void insertA1WithoutTx() throws Exception {
        a1Dao.insert(1, 100);
        a1Dao.insert(2, 200);
    }

//  @Transactional(rollbackFor = Exception.class)     // Exception과 그 자손들까지 rollback 하도록 선언
    @Transactional      // RuntimeException, Error만 rollback 한다.
    public void insertA1WithoutTxFail() throws Exception {
        a1Dao.insert(1, 100);
        a1Dao.insert(1, 200);
    }

    @Transactional
    public void insertA1WithoutTxSuccess() throws Exception {
        a1Dao.insert(1, 100);
        a1Dao.insert(2, 200);
    }
}
