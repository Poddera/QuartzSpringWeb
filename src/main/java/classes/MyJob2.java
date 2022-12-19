package classes;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class MyJob2 implements Job{	
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("This is my JOB_DOS (2)");
	}

}
