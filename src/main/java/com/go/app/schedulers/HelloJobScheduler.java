package com.go.app.schedulers;

import javax.annotation.PostConstruct;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.go.app.jobs.HelloJob;
import com.go.app.triggers.CronTriggerQuartz;
import com.go.app.triggers.SimpleTriggerQuartz;

@Component
public class HelloJobScheduler {

	@Autowired
	private SimpleTriggerQuartz simpleTriggerQuartz;

	// @Autowired
	// private CronTriggerQuartz cronTriggerQuartz;

	@PostConstruct
	public void initialize() {
		JobDetail helloJob = JobBuilder.newJob(HelloJob.class).withIdentity("dummyJobName", "group1").build();
		try {
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(helloJob, simpleTriggerQuartz.getSimpleTriggerRunsEveryFiveSeconds());
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
