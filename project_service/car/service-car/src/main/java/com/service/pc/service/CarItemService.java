package com.service.pc.service;

import com.service.car.apilist.model.CarItemModel;
import com.service.pc.dao.CarItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 汽车名
 * @Author: lgw
 * @Date: 2020/07/03
 */
@Service
public class CarItemService {
    @Resource
    private CarItemMapper carNameMapper;

    public List<CarItemModel> findAllCarName(){
        return carNameMapper.findAllCarName();
    }

    public boolean insertCarName(CarItemModel model){
        try{
            carNameMapper.insertCarName(model);
            return true;
        }catch (RuntimeException ex){
            throw new RuntimeException("信息保存失败！");
        }
    }
}
