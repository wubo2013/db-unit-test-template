package com.wubo.test;

import com.wubo.test.constant.AppConstant;
import com.wubo.test.model.entity.TeacherEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

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
    public void testStaticVar(){
        log.info("teacherEntity tname->{}" , teacherEntity.getTname());
    }
}
