package com.wubo.test;

import com.wubo.test.rpc.ITestFeignService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.annotation.Resource;

@Slf4j
public class FeignTest  extends TestApplicationTests{

    @Resource
    private ITestFeignService testFeignService;

    @Before
    public void mock(){
        Mockito.when(testFeignService.getBaidu())
                .thenReturn("mock result");
    }

    @Test
    public void testFeign(){
        log.info(testFeignService.getBaidu());
    }

}
