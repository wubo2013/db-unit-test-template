package com.wubo.test.web;

import com.wubo.test.model.entity.StudentEntity;
import com.wubo.test.rpc.ITestFeignService;
import com.wubo.test.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("student")
public class StudentController {
    @Resource
    private StudentService service;

    @Resource
    private ITestFeignService testFeignService;

    @GetMapping
    public String get(Long id){
        StudentEntity byId = service.getById(id);
        if(byId == null){
            return "not exist";
        }
        else {
            return byId.toString();
        }
    }

    @GetMapping("baidu")
    public String getBaidu(){
        return testFeignService.getBaidu();
    }
}
