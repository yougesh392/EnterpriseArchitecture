package edu.miu.cs544;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
       // ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        System.out.println("Testing Spring Startup");
        ClassA classA = context.getBean("classA", ClassA.class);
        classA.showText();
        context.close();
    } 
}
