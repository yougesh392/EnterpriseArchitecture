package edu.mum.cs544;

import javax.persistence.EntityManager;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		EntityManager em =  EntityManagerHelper.getCurrent();
		em.getTransaction().begin();

		Student a = em.find(Student.class, studentid);
		em.getTransaction().commit();
		em.close();
		return a;
	}
}
