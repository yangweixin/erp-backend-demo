package top.oyoung.erp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private ValueOperations<String, Object> valueOperations;

    /**
     * @Author: Yang Weixin
     * @Description: 默认设置值，过期时间为60分钟
     * @DateTime: 2018/7/11 上午11:47
     */
    public void setValue(String key, Object value){
        setValue(key, value,60*1000);
    }
    public void setValue(String key, Object value, long expired){
        valueOperations.set(key, value,expired, TimeUnit.MILLISECONDS);
    }

    public <T> T getValue(String key){
        Object value = valueOperations.get(key);
        if(value != null){
            return (T)value;
        }

        return null;
    }

}
