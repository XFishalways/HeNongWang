package com.bug.henong.service;

import com.bug.henong.dao.BusinessBuyrecordDao;
import com.bug.henong.entity.BusinessBuyrecord;
import com.bug.henong.entity.Farmer;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("BusinessBuyerRecordService")
public class BusinessBuyRecordService {
    private BusinessBuyrecordDao businessBuyrecordDao =new BusinessBuyrecordDao();

    /**得到购物记录信息*/
    public BusinessBuyrecord getBuyRecordById(String id) throws SQLException {
        return businessBuyrecordDao.findOneRecord(id);
    }
}
