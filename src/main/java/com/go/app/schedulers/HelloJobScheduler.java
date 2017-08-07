package com.go.app.schedulers;

import javax.annotation.PostConstruct;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.go.app.jobs.HelloJob;
import com.go.app.jobs.ListenerExampleJob;
import com.go.app.listeners.ListenerExampleJobListner;
import com.go.app.triggers.CronTriggerQuartz;
import com.go.app.triggers.SimpleTriggerQuartz;

@Component
public class HelloJobScheduler {

	@Autowired
	private SimpleTriggerQuartz simpleTriggerQuartz;

	@Autowired
	private CronTriggerQuartz cronTriggerQuartz;

	@Autowired
	private ListenerExampleJobListner listenerExampleJobListner;

	@Autowired
	private ListenerExampleJob listenerExampleJob;

	@PostConstruct
	public void initialize() throws SchedulerException {

		// Method to schedule hello job
		System.out.println("----------JOB1----------------");
		scheduleHelloJob();
		System.out.println("----------------JOB2-----------");
		scheduleListnerExampleJob();

	}

	public void scheduleListnerExampleJob() throws SchedulerException {
		JobKey jobKey = new JobKey("ListnerExampleJob", "group2");
		JobDetail listenerExampleJob = JobBuilder.newJob(ListenerExampleJob.class).withIdentity(jobKey).build();
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.getListenerManager().addJobListener(listenerExampleJobListner, KeyMatcher.keyEquals(jobKey));
		scheduler.start();
		scheduler.scheduleJob(listenerExampleJob, simpleTriggerQuartz.getSimpleTriggerRunsEveryFiveSeconds());
	}

	public void scheduleHelloJob() {
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
