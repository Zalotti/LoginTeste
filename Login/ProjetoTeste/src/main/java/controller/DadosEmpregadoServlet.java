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
        try {
            List<Employee> usuarios = employeeDao.listarUsuarios();
            
            request.setAttribute("usuarios", usuarios);
            
            // Encaminha para o JSP responsável por exibir os dados
            request.getRequestDispatcher("details.jsp").forward(request, response);
        } catch (SQLException e) {
            // Trate os erros adequadamente
            e.printStackTrace();
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
