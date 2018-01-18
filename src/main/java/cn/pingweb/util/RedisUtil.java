package cn.pingweb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Locale;

/**
 * @author zhuyuping
 * @date 2018/1/16.
 */
//@Repository
public class RedisUtil {

    @Autowired
    private JedisLite jedisLite;


    private <T> T getObjectFromRedis(String table, String key, Class<T> c) {
        try {
            String objectKey = table + "_" + key;
            objectKey = objectKey.toUpperCase(Locale.ENGLISH);
            String result = jedisLite.stringGet(objectKey);
            if (result != null) {
                return GsonUtil.fromJson(result, c);
            }
        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    /**
     * 添加对象
     *
     * @param table 表名
     * @param key   key
     * @param obj   value
     * @param exp   expire (second)
     * @return 结果
     */
    public boolean addObject(String table, String key, Object obj, int exp) {
        String objectKey = table + "_" + key;
        objectKey = objectKey.toUpperCase(Locale.ENGLISH);
        String json = GsonUtil.toJson(obj);
        boolean addResult = false;
        try {
            if (exp == 0) {
//                addResult = jedisLite.getTemplate().setnx(objectKey, json);
            } else {
//                addResult = jedisLite.getTemplate().setnxex(objectKey, json, exp);
            }

        } catch (Exception e) {
//            log.error(e.getMessage(), e);
        }
        return addResult;
    }
}
