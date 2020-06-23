package com.service.base.apilist.cache.cachekey;

import static com.service.base.apilist.cache.cachekey.CacheKeyType.CacheBaseType.*;

/**
 * 缓存类型,添加模块的缓存类型{@link CacheKeyType}
 * Created by yoara on 2015/12/21.
 */
public enum CacheKeyType {
	/********************组件通用缓存*******************/
	/**session**/
	SESSION(COMMON),
	/** 分布式锁 **/
	REDIS_LOCK(COMMON),
	LOGIN_USER_TOKEN(COMMON),
	USER_INFO(USER),
	;

	CacheKeyType(CacheBaseType baseType) {
		this.baseType = baseType;
	}

	private CacheBaseType baseType;

	public CacheBaseType getBaseType() {
		return baseType;
	}
	public enum CacheBaseType{
		COMMON,
		USER
	}
}
