package edu.mum.cs544;

import edu.mum.cs544.Final_Exam.Second;
import edu.mum.cs544.Final_Exam.Third;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
//import sun.tools.jconsole.JConsole;

//Spring will create the object that's why it is made component
@Component
@Aspect
public class LogAspect {
    @Value("Test")
    private String text;
    @PostConstruct
    public  void start(){
        System.out.println("MyAspect start method - text: " + text);
    }
    @Around("execution(* edu.mum.cs544..*.*get*(..))")
    public Object beforeTrace(ProceedingJoinPoint pjp) throws Throwable{
        Object s  = pjp.getTarget();
        if(s instanceof Third){
            return "Something";
        }
        return pjp.proceed();
    }

    //String is a point cut to tell the compiler on which method it has to execute
//    @After("execution(public void sendEmail(String,String))" + " && args(email,msg))")
//    public void logAfter(JoinPoint joinpoint,String email,String msg) {
//
//        System.out.println("+++ log +++ called from the methodNane= " + joinpoint.getSignature().getName());
//        //arguments object gets all the arguments of the called method
////        Object[] signatureArgs = joinpoint.getArgs();
////
////        for (Object signatureArg: signatureArgs) {
////            System.out.println(signatureArg);
////        }
//        System.out.println("message= "+ msg);
//        System.out.println("email= "+ email);
//        System.out.println(joinpoint.getThis().getClass().getSimpleName());
//        EmailSender emailSender = (EmailSender) joinpoint.getTarget();
//
//        System.out.println("outgoing mail server= " + emailSender.getOutgoingMailServer());
//
//    }
//    @Around("execution(* edu.mum.cs544.CustomerDAO.*(..))")
//    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
//        StopWatch sw = new StopWatch();
//        sw.start(call.getSignature().getName());
//        Object retVal = call.proceed();
//        sw.stop();
//        long totaltime = sw.getLastTaskTimeMillis();
//        System.out.println(totaltime);
//        return retVal;
//    }
}
