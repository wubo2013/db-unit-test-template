package com.wubo.test.service;

import com.wubo.test.TestApplicationTests;
import com.wubo.test.model.entity.TeacherEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
public class TeacherServiceTest extends TestApplicationTests {

    @Resource
    private TeacherService teacherService;

    @Test
    public void testInsert(){
        TeacherEntity build = TeacherEntity.builder()
                .cname("1231")
                .edu("da xue")
                .tname("haha")
                .build();

        boolean save = teacherService.save(build);

        List<TeacherEntity> list = teacherService.list();
        log.info("list size->{} ,{}", list.size() ,list);
    }
}
