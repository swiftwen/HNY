package com.weiye.workflow.auto;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 测试自动节点
 * 
 * @author Liweiye
 * @date 2018年12月14日
 */
@Service
public class TestAuto implements JavaDelegate {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(DelegateExecution execution) {

        logger.info("自动节点开始执行");
    }

}
