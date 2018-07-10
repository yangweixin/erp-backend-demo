package top.oyoung.erp.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import top.oyoung.erp.dao.UserDao;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private ValueOperations<String, Object> valueOperations;
    @Autowired
    private UserDao userDao;

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
//
//    public User getUserSafe(int id){
//        Object value = valueOperations.get("user"+id);
//        if(value == null){
//
//            if(valueOperations.setIfAbsent("user-mutex",1 )){
//                User user = userDao.getUserById(id);
//                setValue("user"+id, user);
//            }else{
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                getUserSafe(id);
//            }
//        } else{
//            return (User)value;
//        }
//    }

}
