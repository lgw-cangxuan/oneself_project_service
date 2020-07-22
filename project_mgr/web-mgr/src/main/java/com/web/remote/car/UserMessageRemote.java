package com.web.remote.car;

import com.service.base.apilist.RequestResult;
import com.service.car.apilist.form.CarItemForm;
import com.service.car.apilist.form.UserMessageForm;
import com.service.car.apilist.model.CarItemModel;
import com.service.car.apilist.model.UserMessageModel;
import com.service.car.apilist.restful.car.CarItemFeign;
import com.service.car.apilist.restful.car.UserMessageFeign;
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
public class UserMessageRemote {
    @Resource
    private UserMessageFeign userMessageFeign;

    public RequestResult<List<UserMessageModel>> findAllUserMessage(){
        return userMessageFeign.findAllUserMessage();
    }

    public RequestResult<Boolean> insertUserMessage(UserMessageForm form){
        return userMessageFeign.insertUserMessage(form);
    }

}
