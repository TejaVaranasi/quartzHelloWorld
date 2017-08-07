package com.go.app.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

// Job which throws job execution exception to check job listener
@Component
public class ListenerExampleJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		System.out.println("--Started running ListnerExampleJob ------");
		throw new JobExecutionException("Testing with custom exception in Listner Example Job");

	}

}
