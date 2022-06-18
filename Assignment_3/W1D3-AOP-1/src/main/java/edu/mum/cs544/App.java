package edu.mum.cs544;

import edu.mum.cs544.Final_Exam.Third;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Testing Spring Startup");
        Third t = context.getBean(Third.class);
        System.out.println("In main: " + t.getText());
        context.close();
//        ICustomerService customerService = context.getBean("customerService", ICustomerService.class);
//
//        customerService.addCustomer("Frank Brown", "fbrown@acme.com",
//                "mainstreet 5", "Chicago", "60613");
    }
}
