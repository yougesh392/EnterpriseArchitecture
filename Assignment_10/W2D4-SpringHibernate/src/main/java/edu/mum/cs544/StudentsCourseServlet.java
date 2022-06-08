package edu.mum.cs544;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentsCourseServlet", urlPatterns = "/StudentsCourseServlet")
public class StudentsCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext context = getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
		StudentService studentService = applicationContext.getBean(StudentService.class);

		String studentIdStr = request.getParameter("studentid");


		FilterRegistration.Dynamic openInView =  context.addFilter("OpenInView", new OpenEntityManagerInViewFilter());
		openInView.addMappingForUrlPatterns(null, true, "/*");


		long studentid = -1;
		Student student = null;
		
		if (studentIdStr != null && studentIdStr.matches("\\d+")) {
			studentid = Long.parseLong(studentIdStr);
			student = studentService.getStudent(studentid);
		}



		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);		

	}

}
