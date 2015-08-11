package solutions.foodProj.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private final static String URL = "jdbc:mysql://localhost:3306/foodProj";
	private final static String USER = "ishan";
	private final static String PASSWORD = "ishan";

	// loading the mysql driver
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block 	 	
			e.printStackTrace();
		}

	}

	public static Connection connectToDB() {

		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Successfully connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error while connecting");
		}
		

		return con;

	}
	
	
	public static void closeResources (PreparedStatement ps, ResultSet rs, Connection con) {
		try {
			if(ps != null)
			{
				ps.close();
			}
			if(rs != null)
			{
				rs.close();
			}
			if(con != null)
			{
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBUtil.connectToDB();
	}

}
