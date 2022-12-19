package classes;
import org.quartz.spi.TriggerFiredBundle;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;




/**
 * SpringBeanJobFactory instancia manualmente las instancias de los objetos Job cada vez
 * que un Job necesite correr. Por tanto, la autoinyección de Spring necesita ser aplicado 
 * a una instancia Job por el hecho de usar características de autoinyectado en las clases
 * invocadas por una instancia de job (MyJob y MayJob2). 
 * @author vm
 *
 */

public class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {
  
    private transient AutowireCapableBeanFactory beanFactory;
 
    @Override
    public void setApplicationContext(final ApplicationContext context) {
        beanFactory = context.getAutowireCapableBeanFactory();
    }
 
    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }
    
    //https://www.quickprogrammingtips.com/spring-boot/spring-boot-quartz-scheduler-integration.html
}
