package com.wubo.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wubo.test.model.entity.StudentEntity;

public interface StudentService extends IService<StudentEntity> {
        long testInsert(StudentEntity entity);
}
