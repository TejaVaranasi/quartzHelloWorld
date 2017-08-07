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
		Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("HelloJobTriggerName", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
		return cronTrigger;
	}

	public Trigger getCronTriggerEveryThirtySecListenerExampleJob(JobDetail listenerExampleJob) {
		// Cron trigger which runs for every 5 seconds
		Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("ListenerExampleJobTriggerName", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?")).forJob(listenerExampleJob).build();
		return cronTrigger;
	}

}
