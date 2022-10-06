package com.wubo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wubo.test.dao.TeacherMapper;
import com.wubo.test.model.entity.TeacherEntity;
import com.wubo.test.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, TeacherEntity>
        implements TeacherService {
}
