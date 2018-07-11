package top.oyoung.erp.configure;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig extends CachingConfigurerSupport{

    /**
     * @Author: Yang Weixin
     * @Description: 自定义redistemplate
     * @DateTime: 2018/7/11 上午11:46
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        setSerializer(redisTemplate);//设置序列化工具
        return redisTemplate;
    }
    /**
     * @Author: Yang Weixin
     * @Description: 设置redis的序列化器
     * @DateTime: 2018/7/11 上午11:46
     */
    private void setSerializer(RedisTemplate redisTemplate) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
    }

    /**
     * @Author: Yang Weixin
     * @Description: 注入一个操作对象
     * @DateTime: 2018/7/11 上午11:46
     */
    @Bean
    public  ValueOperations<String, Object>  valueOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForValue();
    }

}


