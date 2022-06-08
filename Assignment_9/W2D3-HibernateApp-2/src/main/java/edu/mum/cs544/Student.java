package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Student {
	@Id
	private long studentid;
	private String firstname;
	private String lastname;

	@ManyToMany
	private Collection<Course> courselist = new ArrayList<Course>();

	public Student() {
	}

	public Student(long studentid, String firstname, String lastname) {
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public long getStudentid() {
		return studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Collection<Course> getCourselist() {
		return courselist;
	}

	public void addCourse(Course course) {
		this.courselist.add(course);
	}

}
