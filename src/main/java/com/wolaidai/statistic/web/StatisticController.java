package com.wolaidai.statistic.web;

import com.welab.iam.support.annotation.NoNeedAuth;
import com.welab.iam.support.annotation.UserMobile;
import com.welab.iam.support.annotation.UserUuid;
import com.welab.web.base.views.ResponseVo;
import com.wolaidai.statistic.service.StatisticService;
import com.wolaidai.statistic.web.constant.Urls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cyejing <born.chen@wolaidai.com>.
 */
@RestController
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @PostMapping(value = Urls.Agent.AGENT_CODE)
    public ResponseVo doStatistic(@UserUuid Long uuid, @UserMobile String mobile,
                                  @PathVariable(value = "agentCode") String agentCode) {
        statisticService.doStatistic(agentCode, uuid, mobile);
        return new ResponseVo();
    }

    @GetMapping(value = "/test")
    @NoNeedAuth  //不需要经过拦截的链接
    public ResponseVo test() {
        return new ResponseVo("ok");
    }

    @PostMapping(value = "/test")
    public ResponseVo testPost() {
        return new ResponseVo("do it");
    }
}
