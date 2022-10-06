package com.wubo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wubo.test.dao.StudentMapper;
import com.wubo.test.model.entity.StudentEntity;
import com.wubo.test.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper , StudentEntity>
    implements StudentService {

    @Override
    public long testInsert(StudentEntity entity) {
        return this.baseMapper.insert(entity);
    }
}
