package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ChangePassServlet")
public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "jdbc:mysql://localhost:3306/hello";
		String username = "root";
		String password = "root";
		String uname = request.getParameter("uname");
		//System.out.println(uname);
		String pwd = request.getParameter("newpw");
		//System.out.println(pwd);
		try {
			String sqlInsert = "update login set password = '"+pwd+"' where username = '"+uname+"'";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sqlInsert);
			//st.setString(1,pwd);
			//st.setString(2,uname);
			int result = st.executeUpdate(sqlInsert);
			if (result>0) {
				System.out.println("doi thanh cong");
			}
			else {
				{
					System.out.println("doi ko thanh cong");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
