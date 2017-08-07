package com.go.app.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import java.lang.Thread;

// Job which throws job execution exception to check job listener
@Component
public class ListenerExampleJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		System.out.println("--Started running ListnerExampleJob ------");

		// Making ListenerExampleJob to wait for 20 seconds to test other job is
		// running in between for eveary five seconds
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
