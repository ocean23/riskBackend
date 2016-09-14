package com.wolaidai.statistic.service;

import com.wolaidai.statistic.mapper.StatisticAgentUsersMapper;
import com.wolaidai.statistic.model.StatisticAgentUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by cyejing <born.chen@wolaidai.com>.
 */
@Service
public class StatisticService {
    @Autowired
    private StatisticAgentUsersMapper agentUsersMapper;


    @Transactional(propagation = Propagation.REQUIRED)
    public void doStatistic(String agentCode, Long uuid, String mobile) {

        if (agentCode != null) {
            StatisticAgentUsers agentUsers = new StatisticAgentUsers();

            agentUsers.setAgentCode(agentCode);
            agentUsers.setUuid(uuid);
            agentUsers.setMobile(mobile);
            agentUsers.setCreateAt(new Date());
            agentUsersMapper.insert(agentUsers);
        }
    }
}
