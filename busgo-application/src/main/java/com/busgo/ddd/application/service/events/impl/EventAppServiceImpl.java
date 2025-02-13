package com.busgo.ddd.application.service.events.impl;

import com.busgo.ddd.application.service.events.EventAppService;
import com.busgo.ddd.domain.service.HiDomainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EventAppServiceImpl implements EventAppService {

    //Call domain  Service
    @Resource
    private HiDomainService hiDomainService;
    @Override
    public String sayHi(String who) {
        return hiDomainService.sayHi(who);
    }
}
