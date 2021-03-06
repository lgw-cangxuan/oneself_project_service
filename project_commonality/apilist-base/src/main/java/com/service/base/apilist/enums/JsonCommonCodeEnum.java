package com.service.base.apilist.enums;

/**
 * @Description: API处理结果状态码
 * @Author: lgw
 * @Date: 2020/06/16
 */
public enum JsonCommonCodeEnum implements JsonReturnCodeEnum {
	/** 正常返回 **/
	C0000("处理成功"),
	C0001("处理失败"),
	
	/** 常规的错误码START **/
	E0000("未知服务器错误"),
	E0002("参数不全或无效"),
	E0004("服务器正忙，请稍后"),
	E0005("服务器异常!"),
	E0006("参数格式不符合要求"),
	E0007("用户权限未通过校验"),
	E0008("用户未登录"),
	E0009("CSRF校验不通过"),
	E0010("RSA加密校验不通过"),
	E0011("上传失败!"),
	E0012("上传文件大小超过最大限制!"),
	E0013("请上传小于1M的图片!"),
	E0014("excel上传异常!"),
	E0016("附件为空!"),
	E0017("内部访问限制"),
	/** 常规的错误码END **/
	;
	
	
	
	private String msg;
	
	JsonCommonCodeEnum(String msg){
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
	
	@Override
	public String getStatus() {
		return name();
	}
}
