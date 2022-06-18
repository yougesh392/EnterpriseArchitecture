package edu.mum.cs544.Final_Exam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Second {
    @Value("Thing")
    private String text;

    public Second() {
        String text ="Value";
        System.out.println("Second constructor text is :" + text);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
