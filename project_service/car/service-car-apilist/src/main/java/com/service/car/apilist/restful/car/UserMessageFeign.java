package com.service.car.apilist.restful.car;

import com.service.base.apilist.RequestResult;
import com.service.car.apilist.form.UserMessageForm;
import com.service.car.apilist.model.UserMessageModel;
import com.service.car.apilist.restful.ZoneConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Description: UserMessageFeign
 * @Author: lgw
 * @Date: 2020/06/16
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface UserMessageFeign {
    @RequestMapping(value = "/userMessage/findAllUserMessage", method = RequestMethod.POST)
    RequestResult<List<UserMessageModel>> findAllUserMessage();

    @RequestMapping(value = "/userMessage/insertUserMessage", method = RequestMethod.POST)
    RequestResult<Boolean> insertUserMessage(UserMessageForm model);
}
