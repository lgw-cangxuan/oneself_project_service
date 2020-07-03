package com.service.pc.dao;

import com.service.car.apilist.model.CarItemModel;

import java.util.List;

/**
 * user mapper
 *
 * @author lgw
 * @date 2020/06/16
 */
public interface CarItemMapper {
    /**
     * 列表
     * @return
     */
    List<CarItemModel> findAllCarName();

    /**
     * 添加
     * @param model
     */
    void insertCarName(CarItemModel model);
}
