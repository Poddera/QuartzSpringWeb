package classes;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyJob implements Job {
	
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("This is my JOB_UNO (1)");
	}

}
