package edu.mum.cs544;

import javax.persistence.*;
import java.util.Map;

@Entity
public class School {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Map<Long, Student> studentMap;

    public School() {
    }

    public School(String name, Map<Long, Student> studentMap) {
        this.name = name;
        this.studentMap = studentMap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<Long, Student> studentMap) {
        this.studentMap = studentMap;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students =" + studentMap +
                '}';
    }
}
