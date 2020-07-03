package com.service.car.apilist.restful.car;

import com.service.base.apilist.RequestResult;
import com.service.car.apilist.form.CarItemForm;
import com.service.car.apilist.model.CarItemModel;
import com.service.car.apilist.restful.ZoneConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Description: carItem feign
 * @Author: lgw
 * @Date: 2020/06/16
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface CarItemFeign {
    /**
     * query user info list
     * @return
     */
    @RequestMapping(value = "/carItem/findAllCarName", method = RequestMethod.POST)
    RequestResult<List<CarItemModel>> findAllCarName();

    /**
     * insert user info
     * @param model user info
     * @return
     */
    @RequestMapping(value = "/carItem/insertCarName", method = RequestMethod.POST)
    RequestResult<Boolean> insertCarName(CarItemForm model);
}
