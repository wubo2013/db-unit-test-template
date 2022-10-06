package com.wubo.test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.wubo.test.model.entity.StudentEntity;
import com.wubo.test.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.net.URL;
import java.util.List;

@Slf4j
public class StudentServiceTest extends TestApplicationTests{
    @Resource
    private StudentService studentService;

    @Before
    public void before(){
        URL cl = TestApplication.class.getResource("/");
        log.info("application URL->{}" , cl.toString());
    }

    @Test
    public void testStudent(){
        StudentEntity studentEntity = StudentEntity.builder()
                .cname("1 ban")
                .tname("mr wu").build();
        long save = studentService.testInsert(studentEntity);
        log.info("save result->{},->{}",save ,studentEntity);

        studentEntity.setId(null);

        long save1 = studentService.testInsert(studentEntity);
        log.info("save1 result->{},->{}",save1 ,studentEntity);

        List<StudentEntity> list = studentService.list();
        log.info("size->{}, list-> {}" , list.size(),list.toString());
    }

    @Test
    @DatabaseSetup(value = "/data/student_1.xml")
    public void testStudentSetDate(){
        List<StudentEntity> list = studentService.list();
        log.info("size->{}, list-> {}" , list.size(),list.toString());
    }
}
