package com.web.controller;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.service.base.apilist.enums.JsonCommonCodeEnum;
import com.service.base.apilist.enums.JsonReturnCodeEnum;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Controller公共
 * @Author: lgw
 * @Date: 2020/06/16
 */
public class BaseController {
	public static SerializerFeature[] features = {
			SerializerFeature.WriteMapNullValue,//输出值为null的字段
			SerializerFeature.WriteNullNumberAsZero, //数值字段如果为null,输出为0
			SerializerFeature.WriteNullStringAsEmpty, //字符类型字段如果为null,输出为""
			SerializerFeature.WriteNullListAsEmpty,//List字段如果为null,输出为[]
			SerializerFeature.WriteNullBooleanAsFalse,//Boolean字段如果为null,输出为false,而非null
			SerializerFeature.DisableCircularReferenceDetect};//禁止循环引用检测

	ValueFilter[] valueFilters = new ValueFilter[]{ (obj, name, value) -> {
		if (value != null) {
			if (value instanceof Double || value instanceof BigDecimal) {
				return value.toString();
			}

		}
		return value;
	}
	};
	/**
	 * 返回成功信息不带结果集
	 **/
	protected String returnSuccessInfo() {
		return returnJsonInfoWithFilter(null, JsonCommonCodeEnum.C0000, null, null);
	}

	/**
	 * 返回成功信息
	 **/
	protected String returnSuccessInfo(Object json) {
		return returnJsonInfoWithFilter(json, JsonCommonCodeEnum.C0000, null, null);
	}

	/**
	 * APP返回成功信息串自定义filter
	 **/
	protected String returnAppSuccessInfo(Object json,SerializeFilter filters) {
		return returnJsonInfoWithFilter(json, JsonCommonCodeEnum.C0000, null, filters);
	}

	/**
	 * APP返回成功信息浮点数转为字符串
	 **/
	protected String returnAppSuccessInfo(Object json) {
		return returnJsonInfoWithFilter(json, JsonCommonCodeEnum.C0000, null, valueFilters);
	}


	/**
	 * 返回成功信息
	 **/
	protected String returnSuccessInfo(Object json, SerializeFilter filters) {
		return returnJsonInfoWithFilter(json, JsonCommonCodeEnum.C0000, null, filters);
	}

	/**
	 * 返回成功信息，带时间格式
	 **/
	protected String returnSuccessInfo(Object json, String dateFormat) {
		return returnJsonInfoWithFilter(json, JsonCommonCodeEnum.C0000, dateFormat, null);
	}

	/**
	 * 返回成功信息，带时间格式
	 **/
	protected String returnSuccessInfo(Object json, String dateFormat, SerializeFilter filters) {
		return returnJsonInfoWithFilter(json, JsonCommonCodeEnum.C0000, dateFormat, filters);
	}

	/**
	 * 处理异常，返回出错信息
	 **/
	protected String returnWrong(JsonReturnCodeEnum errCode) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", errCode.getStatus());
		result.put("message", errCode.getMessage());
		result.put("result", null);
		return JSON.toJSONString(result);
	}

	/**
	 * 使用自定义消息
	 **/
	protected String returnWithCustomMessage(String message, JsonReturnCodeEnum code) {
		Map<String, Object> result = new HashMap<>();
		result.put("status", code.getStatus());
		result.put("message", StringUtils.isNotEmpty(message) ? message : code.getMessage());
		result.put("result", null);
		return JSON.toJSONString(result);
	}

	/**
	 * 返回信息
	 **/
	protected String returnJsonInfo(Object json, JsonReturnCodeEnum code) {
		return returnJsonInfoWithFilter(json, code, null, null);
	}

	/**
	 * 返回信息，带时间格式
	 **/
	protected String returnJsonInfo(Object json, JsonReturnCodeEnum code, String dateFormat) {
		return returnJsonInfoWithFilter(json, code, dateFormat, null);
	}

	/**
	 * 处理成功，返回信息带过滤器过滤属性
	 **/
	protected String returnJsonInfoWithFilter(Object json,
											  JsonReturnCodeEnum code, SerializeFilter filters) {
		return returnJsonInfoWithFilter(json, code, null, filters);
	}
	/**
	 * 处理成功，返回信息带过滤器过滤属性
	 **/
	protected String returnJsonInfoWithFilter(Object json,
											  JsonReturnCodeEnum code, String dateFormat, SerializeFilter... filters) {
		Map<String, Object> result = new HashMap<>();
		result.put("status", code.getStatus());
		result.put("message", code.getMessage());
		result.put("result", json);
		return JSON.toJSONString(result, SerializeConfig.globalInstance, filters,
				dateFormat, JSON.DEFAULT_GENERATE_FEATURE, features);
	}
}
