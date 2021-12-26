package foodelicious.cashflow;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Paytable")
public class Paytable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   
	    private static final String	DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Projectfakedb";
	    private static final String USER = "sa";
	    private static final String PASSWORD = "1234";

				
	private static final String SQL = "SELECT * FROM order_cart ";

	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQL);
			ResultSet rs = stmt.executeQuery();
			List<ProjectBean> emps = new ArrayList<>();
			ProjectBean emp = null;
			while (rs.next()) {
				emp = new ProjectBean();
				emp.setMember_id(rs.getString("member_id"));
				emp.setOrder_id(rs.getString("order_id"));
				emp.setProduct_name(rs.getString("product_name"));
				emp.setProduct_sales_figures(rs.getString("product_sales_figures"));
				emp.setProduct_price(rs.getString("product_price"));
				emp.setProduct_total_price(rs.getString("product_total_price"));
				emp.setOrder_date(rs.getString("order_date"));
				emp.setOrder_state(rs.getString("order_state"));
				emps.add(emp);
			}
			request.setAttribute("emps", emps);
			rs.close();
			stmt.close();
			conn.close();
			request.getRequestDispatcher("/project2/GetAllProject.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
