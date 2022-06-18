package edu.mum.cs544.Final_Exam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Lazy
@Component
public class Third extends First {
    @Value("Random")
    private String text;

    public String getText() {
        return text + " " + second.getText();
    }
    @PostConstruct
    public void start(){
        System.out.println("Third starting - text : " + text);
    }
    @PreDestroy
    public void end(){
        System.out.println("Third exiting - text : " + text);
    }

}
