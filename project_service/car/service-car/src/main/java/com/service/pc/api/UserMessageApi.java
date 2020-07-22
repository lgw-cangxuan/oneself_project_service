package com.service.pc.api;

import com.service.base.apilist.RequestResult;
import com.service.car.apilist.form.UserMessageForm;
import com.service.car.apilist.model.UserMessageModel;
import com.service.pc.service.UserMessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/userMessage")
public class UserMessageApi {
    @Resource
    private UserMessageService messageService;

    @PostMapping(value = "/findAllUserMessage")
    public RequestResult<List<UserMessageModel>> findAllUserMessage() {
        return new RequestResult<>(messageService.findAllUserMessage());
    }

    @PostMapping(value = "/insertUserMessage")
    public RequestResult<Boolean> insertUserMessage(@RequestBody UserMessageForm form){ return new RequestResult<>(messageService.insertUserMessage(form));}


}
