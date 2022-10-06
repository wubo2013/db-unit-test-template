package com.wubo.test.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://www.baidu.com/s?wd=keyword&pn=1&ie=utf8&rn=5" ,name = "baidu")
@Component
@Profile("!unittest")
public interface ITestFeignService {
    @GetMapping(value = "/baidu")
    String getBaidu();
}
