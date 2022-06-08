package edu.mum.cs544;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "OpenEntityManagerInView", urlPatterns = "/*")
public class EntityManagerInterceptor  implements Filter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        try {
//            em.getTransaction().begin();
//            filterChain.doFilter(servletRequest, servletResponse);
//            em.getTransaction().commit();
//        }catch (RuntimeException ex){
//            if (em != null && em.isOpen())
//                em.getTransaction().rollback();
//            throw ex;
//        }finally {
//            em.close();
//        }
    }

    @Override
    public void destroy() {

    }
}
