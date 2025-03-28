package in.softronix.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.softronix.entity.Student;
import in.softronix.factory.ServiceFactory;
import in.softronix.service.StudentService;


@WebServlet("/edit/*")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 // Get service instance
        StudentService service = ServiceFactory.getService();

        // Extract student ID from URL
        String param = request.getPathInfo();

        if (param == null || param.equals("/") || !param.substring(1).matches("\\d+")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid student ID");
            return;
        }

        int sid = Integer.parseInt(param.substring(1));
        System.out.println("Fetching details for Student ID: " + sid);

        // Fetch student details
        Student student = service.searchStudent(sid);
        
        String us = service.updateStudent(student);

        if (us != null) {
        	
       
        	
            request.setAttribute("student", student);
            
                       
            RequestDispatcher rd = request.getRequestDispatcher("/edit.jsp");
            rd.forward(request, response);
            System.out.println("tttt...............");
            
        } else {
        	RequestDispatcher rd = request.getRequestDispatcher("/edit.jsp");
            rd.forward(request, response);   
        }
    }

	

}
