package controller;

import java.io.IOException;



import dao.EmployeeDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeDao employeeDao = new EmployeeDao();

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean valid = false; 
		
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        Employee employee = new Employee();

        employee.setUsername(username);
        employee.setPassword(password);

        try {
            valid = employeeDao.loginEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(valid == true) {
        request.setAttribute("username", employee.getUsername());
        request.setAttribute("password", employee.getPassword());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DadosEmpregadoServlet");
		dispatcher.forward(request, response);
        }
        else { 
        	
        }
    }
	

}

