package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Classes;
import com.utilties.HibernateUtils;


/**
 * Servlet implementation class AddClassController
 */
@WebServlet("/AddClasses")
public class AddClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null)
		{
			response.sendRedirect("login.jsp");
		}else
		{
			response.sendRedirect("add_class.jsp");

		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String title=request.getParameter("title");
			String name=request.getParameter("name");

			Classes classes = new Classes();
			classes.setClasstitle(title);
			classes.setClassname(name);

			Session s= HibernateUtils.getSessionFactory().openSession();
			Transaction tx=s.beginTransaction();
			s.save(classes);
			tx.commit();
			s.close();
			response.sendRedirect("classes.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
