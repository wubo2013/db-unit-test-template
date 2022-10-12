package com.wubo.test;

import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.wubo.test.constant.AppConstant;
import com.wubo.test.model.entity.TeacherEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.function.Function;

@Slf4j
public class TestStaticVar extends TestApplicationTests{
    private TeacherEntity teacherEntity = new TeacherEntity();

    @Before
    public void init(){

        ReflectionTestUtils.setField(teacherEntity , "tname" ,"12321321");

        AppConstant.logTestVar();

        // 反射修改静态值
        ReflectionTestUtils.setField(AppConstant.class, "TEST_VAR" ,"12321321");
        AppConstant.logTestVar();
    }

    @Test
    public void testStaticVar() throws Exception {
        log.info("teacherEntity tname->{}" , teacherEntity.getTname());
    }

    private static <T, R> java.lang.invoke.SerializedLambda doSFunction(SFunction<T, R> func) throws Exception {
        // 直接调用writeReplace
        Method writeReplace = func.getClass().getDeclaredMethod("writeReplace");
        writeReplace.setAccessible(true);
        //反射调用
        Object sl = writeReplace.invoke(func);
        java.lang.invoke.SerializedLambda serializedLambda = (java.lang.invoke.SerializedLambda) sl;
        return serializedLambda;
    }

    @Test
    public void testGetLambdaMethod() throws Exception {
        SerializedLambda serializedLambda = doSFunction(TeacherEntity::getTname);
        log.info("method-> {}" , serializedLambda.getImplMethodName());
        log.info("class->{}" , serializedLambda.getImplClass());
    }
}
