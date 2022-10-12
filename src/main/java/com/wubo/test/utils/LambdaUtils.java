package com.wubo.test.utils;

import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.support.*;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LambdaUtils {
    private static final Map<String, Map<String, ColumnCache>> COLUMN_CACHE_MAP = new ConcurrentHashMap();

    public LambdaUtils() {
    }



    public static <T> LambdaMeta extract(SFunction<T, ?> func) {
        if (func instanceof Proxy) {
            return new IdeaProxyLambdaMeta((Proxy)func);
        } else {
            try {
                Method method = func.getClass().getDeclaredMethod("writeReplace");
                return new ReflectLambdaMeta((java.lang.invoke.SerializedLambda)((Method) ReflectionKit.setAccessible(method)).invoke(func));
            } catch (Throwable var2) {
                return new ShadowLambdaMeta(com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda.extract(func));
            }
        }
    }
}
