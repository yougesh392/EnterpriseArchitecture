package edu.mum.cs544;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
//import sun.tools.jconsole.JConsole;

//Spring will create the object that's why it is made component
@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {

    //String is a point cut to tell the compiler on which method it has to execute
    @After("execution(public void sendEmail(String,String))" + " && args(msg,email))")
    public void logAfter(JoinPoint joinpoint,String msg,String email) {

        System.out.println("+++ log +++ called from the methodNane= " + joinpoint.getSignature().getName());
        //arguments object gets all the arguments of the called method
//        Object[] signatureArgs = joinpoint.getArgs();
//
//        for (Object signatureArg: signatureArgs) {
//            System.out.println(signatureArg);
//        }
        System.out.println("message= "+ msg);
        System.out.println("email= "+ email);
        EmailSender emailSender = (EmailSender) joinpoint.getTarget();

        System.out.println("outgoing mail server= " + emailSender.getOutgoingMailServer());

    }
    @Around("execution(* edu.mum.cs544.CustomerDAO.*(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println(totaltime);
        return retVal;
    }
}
