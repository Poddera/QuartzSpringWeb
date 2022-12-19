package classes;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.UnableToInterruptJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @author adrianr 20221912
 *
 */
@Controller
public class JobController {
	
    @Autowired
    private SchedulerFactoryBean scheduler;

    @Autowired
    private ApplicationContext context;
    
    @Autowired
    private JobDetailFactoryBean jobDetail;
    
	
    /**
     * create a new job (MyJob2)
     * @return
     */
    @RequestMapping(value="/addjob2", method=RequestMethod.GET)
	public String addJob2() {
    	System.out.println("HERE!!!");
    	
    	JobDetail jd = JobBuilder.newJob().ofType(MyJob2.class)
    		      .storeDurably()
    		      .withIdentity("job2", "grupo2")  
    		      .withDescription("Invoke Sample Job service...")
    		      .build();
    	
    	Trigger triggerA = TriggerBuilder.newTrigger()
        		.withIdentity("Trigger", "grupo1")
        		.startNow()
        		.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
        		.build();
    	
//        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
//        trigger.setJobDetail(jd);
//        int frequencyInSec = 2;
//        trigger.setRepeatInterval(frequencyInSec * 1000);
//        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
    	
        
    	try {
			scheduler.getScheduler().scheduleJob(jd, triggerA);
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
//    	jobDetail.setJobClass(MyJob2.class);

//		SimpleTriggerFactoryBean cronTrigger = context.getBean(SimpleTriggerFactoryBean.class);
//
//        scheduler.setTriggers(cronTrigger.getObject());
//        scheduler.setJobDetails(jobDetail.getObject());
//		scheduler.start();
		
		return "index.html";
	}
    
    /**
     * method for pausing the scheduler
     * @return
     */
    @RequestMapping(value="/pausescheduler", method=RequestMethod.GET)
	public String pauseJob() {
    	System.out.println("Pause!!!");
    	
		scheduler.stop();
		
		return "index.html";
	}
    
    
    /**
     * method for starting the scheduler
     * @return
     */
    @RequestMapping(value="/startscheduler", method=RequestMethod.GET)
	public String start() {
    	System.out.println("start!!!");
    	
		scheduler.start();
		
		return "index.html";
	}
    
    
    /**
     * method for resuming job1 when It was stopped
     * @return
     */
    @RequestMapping(value="/resumejob1", method=RequestMethod.GET)
	public String startJob1() {
    	System.out.println("start job 1!!!");
    	
    	try {
    		scheduler.getScheduler().resumeJob(new JobKey("job1", "grupo1"));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		return "index.html";
	}
    
    
    /**
     * method for resuming job2 when It was stopped
     * @return
     */
    @RequestMapping(value="/resumejob2", method=RequestMethod.GET)
	public String startJob2() {
    	System.out.println("start job 2!!!");
    	
    	try {
			scheduler.getScheduler().resumeJob(new JobKey("job2", "grupo2"));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		return "index.html";
	}
    
    
    /**
     * method for pausing job1
     * @return
     */
    @RequestMapping(value="/pausejob1", method=RequestMethod.GET)
	public String pauseJob1() {
    	System.out.println("Pause job 1!!!");
    	
    	try {
    		scheduler.getScheduler().pauseJob(new JobKey("job1", "grupo1"));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		return "index.html";
	}
    
    
    /**
     * method for pausing job2
     * @return
     */
    @RequestMapping(value="/pausejob2", method=RequestMethod.GET)
	public String pauseJob2() {
    	System.out.println("Pause job 2!!!");
    	
    	try {
			scheduler.getScheduler().pauseJob(new JobKey("job2", "grupo2"));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		return "index.html";
	}
    
}
