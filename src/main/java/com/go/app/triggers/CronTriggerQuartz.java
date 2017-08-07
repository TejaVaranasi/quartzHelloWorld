package com.go.app.triggers;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Component;

@Component
public class CronTriggerQuartz {
	public Trigger getCronTriggerRunsEveryFiveSeconds() {
		// Cron trigger which runs for every 5 seconds
		Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
		return cronTrigger;
	}

}
