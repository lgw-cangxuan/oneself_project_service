package com.service.base.apilist.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.base.apilist.cache.RedisCache;
import com.service.base.apilist.cache.RedisCacheImpl;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: guowei liu
 * @Date: 2020/06/17
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Bean(name = "redisCache")
    public RedisCache redisCache(RedisConnectionFactory factory) {
        RedisCacheImpl redisCache = new RedisCacheImpl();
        Map<String, RedisTemplate<String, Object>> redisMap = new HashMap<>();
        redisMap.put("SAVE", redisTemplate(factory));
        redisMap.put("QUERY", redisTemplateQuery(factory));
        redisCache.setRedis(redisMap);
        return redisCache;
    }


    /**
     * 选择redis作为默认缓存工具(此种方式使用@Cacheable的时候值是json格式)
     * 与上面的方法二选一
     * @param
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()));

        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);

    }

    /**
     * retemplate相关配置
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        return returnRedisTemplate(factory);
    }

    @Bean(name = "redisTemplateQuery")
    public RedisTemplate redisTemplateQuery(RedisConnectionFactory factory) {
        return returnRedisTemplate(factory);
    }

    private RedisTemplate returnRedisTemplate(RedisConnectionFactory factory){
        RedisTemplate template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(factory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSeial.setObjectMapper(om);

        // 值采用json序列化
        template.setValueSerializer(new StringRedisSerializer());
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());

        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSeial);
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 选择redis作为默认缓存工具(此种方式使用@Cacheable的时候值是Hex格式)
     * 与下面的方法二选一
     * @param
     * @return

     @Bean
     public CacheManager cacheManager(RedisConnectionFactory factory) {
     RedisCacheManager rcm = RedisCacheManager.create(factory);
     return rcm;
     }
     */

    /**
     * 对hash类型的数据操作
     *
     * @param redisTemplate
     * @return

     @Bean
     public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
     return redisTemplate.opsForHash();
     }
     */


    /**
     * 对redis字符串类型数据操作
     *
     * @param redisTemplate
     * @return

     @Bean
     public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
     return redisTemplate.opsForValue();
     }
     */

    /**
     * 对链表类型的数据操作
     *
     * @param redisTemplate
     * @return

     @Bean
     public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
     return redisTemplate.opsForList();
     }
     */

    /**
     * 对无序集合类型的数据操作
     *
     * @param redisTemplate
     * @return

     @Bean
     public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
     return redisTemplate.opsForSet();
     }
     */

    /**
     * 对有序集合类型的数据操作
     *
     * @param redisTemplate
     * @return

     @Bean
     public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
     return redisTemplate.opsForZSet();
     }
     */
}
