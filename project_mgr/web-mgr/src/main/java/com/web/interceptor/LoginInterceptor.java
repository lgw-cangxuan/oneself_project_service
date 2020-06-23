package com.web.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.service.base.apilist.cache.RedisCache;
import com.service.base.apilist.cache.cachekey.CacheKeyType;
import com.service.base.apilist.util.MD5_Encoding;
import com.web.config.MgrReturnCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 拦截器
 * @Author: lgw
 * @Date: 2020/06/23
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisCache redisCache;

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            return true;
        }
        String authorization = request.getHeader("Authorization");
        //头文件不能为空
        if(StringUtils.isNotEmpty(authorization)){
            String[] str = authorization.split("_");
            //必须是手机号与手机号md5加密组成
            if(str.length == 2){
                String token = redisCache.get(CacheKeyType.LOGIN_USER_TOKEN,str[0]).toString();
                //手机号在redis查的到token
                if(StringUtils.isNotEmpty(token)){
                    //加密正确且与redis的token一致
                    if(MD5_Encoding.verify(str[0],str[1]) && StringUtils.equals(token,authorization)){
                        return true;
                    }
                }
            }
        }
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", response.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Vary", "Origin");
        Map<String, Object> result = new HashMap<>();
        result.put("status", MgrReturnCodeEnum.F1006);
        result.put("message","用户登录授权信息已过期,请重新登录");
        printWriter.write(JSONObject.toJSONString(result));
        printWriter.flush();
        return false;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //System.out.println("执行了TestInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //System.out.println("执行了TestInterceptor的afterCompletion方法");
    }
}