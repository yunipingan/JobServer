package cn.pingweb.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * @author zhuyuping
 * @date 2018/1/16.
 */
public class GsonUtil {

    private static ThreadLocal<Gson> excludetlGson = new ThreadLocal<Gson>();
    private static ThreadLocal<Gson> defaultGson = new ThreadLocal<Gson>();

    private GsonUtil() {
    }

    public static Gson getGson() {
        Gson result = defaultGson.get();
        if (result == null) {
            result = new Gson();
            defaultGson.set(result);
        }
        return result;
    }

    public static Gson getGsonexclude() {
        Gson result = excludetlGson.get();
        if (result == null) {
            result = new GsonBuilder().excludeFieldsWithModifiers(Modifier.PRIVATE | Modifier.PROTECTED).create();
            excludetlGson.set(result);
        }
        return result;
    }

    /**
     * 获得gson对象
     * @param dateFormat
     * @return
     */
    public static Gson getDateDmtGson(String dateFormat) {
        return new GsonBuilder().setDateFormat(dateFormat).create();
    }

    public static Gson getSeriGson() {
        return new GsonBuilder().serializeNulls().create();
    }

    /**
     * 转换成josn
     * @param object 要转换成json的对象
     * @return json字符串
     */
    public static String toJson(Object object) {
        return getGson().toJson(object);
    }

    public static String toJson(Object object,Type typeOfSrc) {
        return getGson().toJson(object,typeOfSrc);
    }

    /**
     * json转换成对应的对象
     * @param json 要转换的json
     * @param clazz json对应的对象类型
     * @param <T> 对象类型
     * @return json转换成对应的对象
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return getGson().fromJson(json, clazz);
    }

    /**
     * json转换成对应的对象
     * @param json 要转换的json
     * @param clazz json对应的对象类型
     * @param <T> 对象类型
     * @return json转换成对应的对象
     */
    public static <T> T fromJson(Reader json, Class<T> clazz) {
        return getGson().fromJson(json, clazz);
    }

    /**
     * json转换成对应的对象
     * @param json 要转换的json
     * @param typeOfT json对应的对象类型
     * @param <T> 对象类型
     * @return json转换成对应的对象
     */
    public static <T> T fromJson(String json, Type typeOfT) {
        return getGson().fromJson(json, typeOfT);
    }

}
