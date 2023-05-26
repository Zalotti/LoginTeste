package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Employee;


public class EmployeeDao {
	
	 public int registerEmployee(Employee employee) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO employee" +
	            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
	            " (?, ?, ?, ?, ?,?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, (int) (Math.random() * (100 - 1) + 1));
	            preparedStatement.setString(2, employee.getFirstName());
	            preparedStatement.setString(3, employee.getLastName());
	            preparedStatement.setString(4, employee.getUsername());
	            preparedStatement.setString(5, employee.getPassword());
	            preparedStatement.setString(6, employee.getAddress());
	            preparedStatement.setString(7, employee.getContact());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public boolean loginEmployee(Employee employee) throws ClassNotFoundException {
	        String GET_USERS_SQL = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?" +
	        		                " AND PASSWORD = ?;";

	        boolean result = false;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_SQL)) {
	        	preparedStatement.setString(1, employee.getUsername());
	            preparedStatement.setString(2, employee.getPassword());
	            
	            
	            System.out.println(preparedStatement);
	            
	            ResultSet rs = preparedStatement.executeQuery();
	            result = rs.next();
	            System.out.println(rs);

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public List<Employee> listarUsuarios(Employee employee) throws ClassNotFoundException {
		 
	        List<Employee> usuarios = new ArrayList<Employee>();
	        
	        String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?" +
	        " AND PASSWORD = ?;";
	        
	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, employee.getUsername());
	            statement.setString(2, employee.getPassword());
	            
	            
	            System.out.println(statement);
	            
	            ResultSet rs = statement.executeQuery();
	            
	            while(rs.next()) {
	            employee.setId(rs.getInt("id"));
	            employee.setFirstName(rs.getString("first_name"));
	            employee.setLastName(rs.getString("last_name"));
	            employee.setUsername(rs.getString("username"));
	            employee.setPassword(rs.getString("password"));
	            employee.setAddress(rs.getString("address"));
	            employee.setContact(rs.getString("contact"));
	            }
	 
	            usuarios.add(employee);
	            
		        rs.close();
		        statement.close();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }      
	        return usuarios;

}
}
