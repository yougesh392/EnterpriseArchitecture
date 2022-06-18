package edu.mum.cs544.bank;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class AdviceClass {
    @Autowired
    public ILogger logger;

    @After("execution(* edu.mum.cs544.bank.dao.*.*(..))")
    public void loggerService(JoinPoint joinPoint){
        logger.log("$$$$$:" + joinPoint.getSignature().getName());
    }
    @Around("execution(* edu.mum.cs544.bank.service.*.*(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println("Time: " + totaltime);
        return retVal;
    }
    @After("execution(public void sendJMSMessage(String))" + " && args(msg))")
    public void jmsLogger(JoinPoint joinPoint,String msg){
        logger.log("%%%%% jms msg" + msg);
    }
}
