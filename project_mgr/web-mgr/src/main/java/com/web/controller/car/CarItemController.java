package com.web.controller.car;

import com.service.car.apilist.form.CarItemForm;
import com.service.car.apilist.model.CarItemModel;
import com.web.controller.BaseController;
import com.web.remote.car.CarItemRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: carItem controller
 * @Author: lgw
 * @Date: 2020/06/16
 */
@RestController
@RequestMapping(value = "/car/carItem",produces = {"application/json;charset=UTF-8"})
@Api(value = "汽车大类相关", description = "汽车大类相关接口", tags = "汽车大类相关")
public class CarItemController extends BaseController {
    @Resource
    private CarItemRemote carNameRemote;

    @GetMapping("/findAllCarName")
    @ApiOperation(value = "查询汽车大类列表")
    @ApiResponses({
            @ApiResponse(message = "信息",code = 1,response = CarItemModel.class)
    })
    public String findAllCarName() {
        List<CarItemModel> list = carNameRemote.findAllCarName().pickBody();
        return returnSuccessInfo(list);
    }

    @PostMapping("insertCarName")
    @ApiOperation(value = "保存汽车大类信息")
    @ApiResponses({
            @ApiResponse(message = "信息",code = 1,response = Boolean.class)
    })
    public String insertCarName(@RequestBody CarItemForm form){
        return returnSuccessInfo(carNameRemote.insertCarName(form).pickBody());
    }
}

