package com.wuliu.service.impl;

import com.wuliu.dao.DriverDao;
import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;
import com.wuliu.service.DriverService;
import com.github.pagehelper.PageHelper;
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

    /*查询在职运输人员
     *
     * */
    @Override
    public List<Driver> findDriverList(int currentPage, int pageSize, String driver_name) {
        PageHelper.startPage(currentPage, pageSize);
        return driverDao.findDriverList(driver_name);
    }

    /*修改运输人员
     *
     * */
    @Override
    public int saveDriver(Driver driver) {
        driver.setDriver_state(0);
        return driverDao.saveDriver(driver);

    }

    /*查重
     *
     * */
    @Override
    public Driver findDriverByName(String driver_username) {
        return driverDao.findDriverByName(driver_username);
    }

    /*根据ID查找运输人员
     *
     * */
    @Override
    public Driver findDriverById(int driver_id) {
        return driverDao.findDriverById(driver_id);
    }

    /*修改运输人员
     *
     * */
    @Override
    public int updateDriver(Driver driver) {
        return driverDao.updateDriver(driver);
    }

    /*删除运输人员
     *
     * */
    @Override
    public int deleteDriver(int driver_id) {
        return driverDao.deleteDriver(driver_id);
    }

    /*
     * 停职司机
     * */
    @Override
    public int updateDriverStateById(int driver_id) {
        return driverDao.updateDriverStateById(driver_id);
    }

    /*
     * 根据司机id查找运单
     * */
    @Override
    public List<Order> findOrderByDid(int currentPage, int pageSize, int driver_id, String search_address) {
        PageHelper.startPage(currentPage, pageSize);
        return driverDao.findOrderByDid(driver_id, search_address);
    }

    /*
     * 修改运单状态
     * */
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

    /*
     *根据司机id查询正在进行的运单
     * */
    @Override
    public Order findOneOrder(int driver_id) {
        return driverDao.findOneOrder(driver_id);
    }
}
