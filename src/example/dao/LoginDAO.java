package example.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
public class LoginDAO {
			String sql = "select * from login where username=? and password=?";
			String sqlInsert = "update login set password = ? where username = ?";
			String url = "jdbc:mysql://localhost:3306/hello";
			String username = "root";
			String password = "root";
	public boolean check(String uname,String pass) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2,pass);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		return false;
	}
	/*public void updatePassword(String pass,String uname ) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sqlInsert);
			st.setString(1,pass);
			st.setString(2,uname);
			int result= st.executeUpdate(sqlInsert);
			if (result>0) {
				System.out.println("doi pass thanh cong");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}

}*/
}
