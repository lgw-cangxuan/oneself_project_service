package com.service.pc.dao;

import com.service.car.apilist.form.UserMessageForm;
import com.service.car.apilist.model.UserMessageModel;

import java.util.List;

/**
 * userMessage mapper
 *
 * @author lgw
 * @date 2020/06/16
 */
public interface UserMessageMapper {
    List<UserMessageModel> findAllUserMessage();

    int insertUserMessage(UserMessageForm form);
}
