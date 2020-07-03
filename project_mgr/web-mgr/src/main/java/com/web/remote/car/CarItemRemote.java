package com.web.remote.car;

import com.service.base.apilist.RequestResult;
import com.service.car.apilist.form.CarItemForm;
import com.service.car.apilist.model.CarItemModel;
import com.service.car.apilist.restful.car.CarItemFeign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: carItem remote
 *
 * @author lgw
 * @date 2020/06/16
 */

@Service
public class CarItemRemote {
    @Resource
    private CarItemFeign carNameFeign;

    public RequestResult<List<CarItemModel>> findAllCarName(){
        return carNameFeign.findAllCarName();
    }

    public RequestResult<Boolean> insertCarName(CarItemForm form){
        return carNameFeign.insertCarName(form);
    }

}
