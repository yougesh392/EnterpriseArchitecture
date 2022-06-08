package edu.mum.cs544;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentService {

	@Resource
	private StudentDAO studentdao;


	public Student getStudent(long studentid) {
		EntityManager em = EntityManagerHelper.getCurrent();
		em.getTransaction().begin();
		Student student = studentdao.load(studentid);
		em.getTransaction().commit();
		em.close();
		return student;
	}
}
