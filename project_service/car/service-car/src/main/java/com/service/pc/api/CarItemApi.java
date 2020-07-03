package com.service.pc.api;

import com.service.base.apilist.RequestResult;
import com.service.car.apilist.model.CarItemModel;
import com.service.pc.service.CarItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/carItem")
public class CarItemApi {
    @Resource
    private CarItemService carNameService;

    @PostMapping(value = "/findAllCarName")
    public RequestResult<List<CarItemModel>> findAllUser() {
        return new RequestResult<>(carNameService.findAllCarName());
    }

    @PostMapping(value = "/insertCarName")
    public RequestResult<Boolean> insertUser(@RequestBody CarItemModel model){ return new RequestResult<>(carNameService.insertCarName(model));}


}
