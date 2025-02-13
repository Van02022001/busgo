package com.busgo.ddd.infratructure.persistence.repository;

import com.busgo.ddd.domain.repository.HiDomainRepository;
import org.springframework.stereotype.Service;

@Service
public class HiInfrastructureRepositoryImpl implements HiDomainRepository {
    @Override
    public String sayHi(String who) {
        return "Hi Infrastructure " ;
    }
}
