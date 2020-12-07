package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {
    @Autowired
    AgentRepository agentRepository;

    @Transactional
    @Override
    public Agent save(Agent agent){
        return agentRepository.save(agent);
    }
}
