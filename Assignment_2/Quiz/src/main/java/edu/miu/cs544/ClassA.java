package edu.miu.cs544;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class ClassA {
    private String text;
    private ClassB classB;
    ClassA(String text){
        this.text = text;
        System.out.println("Class A constructor - text "+ text);

    }
    public void setClassB(ClassB classB){
        this.classB = classB;
    }
    public void showText(){
        System.out.println("Class A text: " + text);
        classB.showText();
    }
    public void init(){
        System.out.println("Class A init - text"+ text);
    }
    public void destroy(){
        System.out.println("Class A destroy");
    }
}
