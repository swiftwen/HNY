package com.wp.hny.jobs;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.wp.hny.jobs.job.HelloWorldJob;

/**
 * 
 * @author swiftwen
 * @date 2018年11月28日 上午10:25:37
 */
public class Main {

	public static void main(String[] args)throws Exception {

		SchedulerFactory factory = new StdSchedulerFactory();
		
		Scheduler scheduler = factory.getScheduler();
	
		
		JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class)
				.withIdentity("job1", "job-group").build();
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "job-group")
				.startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
				.build();
		
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
	}
}
