package com.go.app.listeners;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerExampleJobListner implements JobListener {

	public static final String LISTENER_NAME = "ListnerExampleJobListner";

	@Override
	public String getName() {
		return LISTENER_NAME;
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		String jobName = context.getJobDetail().getKey().toString();
		System.out.println("jobToBeExecuted");
		System.out.println("Job : " + jobName + " is going to start...");

	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		// https://stackoverflow.com/questions/16568315/when-jobexecutionvetoed-of-joblistener-will-be-execured-in-quartz-scheduler
		System.out.println("jobExecutionVetoed");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		System.out.println("jobWasExecuted");

		String jobName = context.getJobDetail().getKey().toString();
		System.out.println("Job : " + jobName + " is finished...");

		if (!jobException.getMessage().equals("")) {
			System.out.println("Exception thrown by: " + jobName + " Exception: " + jobException.getMessage());
		}

	}

}
