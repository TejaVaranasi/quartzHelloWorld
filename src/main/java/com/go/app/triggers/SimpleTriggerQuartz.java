package com.go.app.triggers;

import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleTriggerQuartz {

	public Trigger getSimpleTriggerRunsEveryFiveSeconds() {
		Trigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();
		return simpleTrigger;
	}

}
