package com.go.app.triggers;

import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleTriggerQuartz {

	public Trigger getSimpleTriggerRunsEveryFiveSeconds(JobDetail helloJob) {
		// Simple trigger to invoke a job every 5 seconds
		Trigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
				.forJob(helloJob).build();
		return simpleTrigger;
	}

}
