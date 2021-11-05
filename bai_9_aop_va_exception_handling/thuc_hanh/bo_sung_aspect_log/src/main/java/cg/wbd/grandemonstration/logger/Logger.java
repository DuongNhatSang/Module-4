package cg.wbd.grandemonstration.logger;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }
    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.findAll(..))")
    public void log() {}
}
