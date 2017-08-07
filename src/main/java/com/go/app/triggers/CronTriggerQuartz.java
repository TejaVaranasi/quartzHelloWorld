package com.go.app.triggers;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Component;

@Component
public class CronTriggerQuartz {
	public Trigger getCronTriggerRunsEveryFiveSeconds(JobDetail helloJob) {
		Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
		return cronTrigger;
	}

}
