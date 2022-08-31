package com.wuliu.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliu.dao.DriverDao;
import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;
import com.wuliu.service.DriverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Resource
    private DriverDao driverDao;

    @Override
    public Driver checkLogin(String driver_username, String driver_password) {
        return driverDao.checkLogin(driver_username, driver_password);
    }

    @Override
    public List<Driver> findDriverList(int currentPage, int pageSize, String driver_name) {
        PageHelper.startPage(currentPage, pageSize);
        return driverDao.findDriverList(driver_name);
    }

    @Override
    public int saveDriver(Driver driver) {
        driver.setDriver_state(0);
        return driverDao.saveDriver(driver);

    }

    @Override
    public Driver findDriverByName(String driver_username) {
        return driverDao.findDriverByName(driver_username);
    }

    @Override
    public Driver findDriverById(int driver_id) {
        return driverDao.findDriverById(driver_id);
    }

    @Override
    public int updateDriver(Driver driver) {
        return driverDao.updateDriver(driver);
    }

    @Override
    public int deleteDriver(int driver_id) {
        return driverDao.deleteDriver(driver_id);
    }

    @Override
    public int updateDriverStateById(int driver_id) {
        return driverDao.updateDriverStateById(driver_id);
    }

    @Override
    public List<Order> findOrderByDid(int currentPage, int pageSize, int driver_id, String search_address) {
        PageHelper.startPage(currentPage, pageSize);
        return driverDao.findOrderByDid(driver_id, search_address);
    }

    @Override
    public int changeOrderState(int order_id, int order_state, int driver_id, int tran_id) {
        int i = 0;
        if (order_state == 0) {
            order_state = 1;
            i = driverDao.changeOrderState(order_id, order_state);
            return i;
        }
        if (order_state == 1) {
            order_state = 2;
            i = driverDao.changeOrderState(order_id, order_state);
            return i;
        }
        if (order_state == 2) {
            order_state = 3;
            i = driverDao.changeOrderState(order_id, order_state);
            driverDao.changeDriverState0(driver_id);
            driverDao.changeTranState1(tran_id);
            return i;
        }
        return i;
    }

    @Override
    public Order findOneOrder(int driver_id) {
        return driverDao.findOneOrder(driver_id);
    }
}
