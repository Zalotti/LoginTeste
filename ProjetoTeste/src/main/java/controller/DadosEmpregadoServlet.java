package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import dao.EmployeeDao;

import model.Employee;

@WebServlet("/DadosEmpregadoServlet")
public class DadosEmpregadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao employeeDao = new EmployeeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DadosEmpregadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 Employee employee = new Employee();
    	 
    	String username = (String) request.getAttribute("username");
    	String password = (String) request.getAttribute("password");
    	
    	employee.setUsername(username);
        employee.setPassword(password);
    	
        List<Employee> usuarios;
		try {
			usuarios = employeeDao.listarUsuarios(employee);
			request.setAttribute("usuarios", usuarios);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Encaminha para o JSP responsável por exibir os dados
		request.getRequestDispatcher("/WEB-INF/views/details.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
