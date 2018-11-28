package com.wp.hny.jobs.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * @author swiftwen
 * @date 2018年11月28日 上午10:24:53
 */
public class HelloWorldJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("hello world");
	}
}
