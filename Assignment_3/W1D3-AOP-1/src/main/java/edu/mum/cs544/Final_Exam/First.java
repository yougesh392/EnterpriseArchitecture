package edu.mum.cs544.Final_Exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class First {
    protected Second second;

    public First() {
        System.out.println("First constructor - Second: "+ second);
    }
    @Autowired
    public void getSecond(Second second) {
        System.out.println("Setting second");
        this.second =second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }
}
