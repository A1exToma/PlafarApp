package Login_Sys;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class DBConnect {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	String url=("jdbc:mysql://localhost:3306/logindetalis");
	String username=("root");
	String password=("");
	
	public DBConnect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		//1. Get a connection to database
		
		con=DriverManager.getConnection(url,username,password);
		
		//2. Create a statement
		
		st=con.createStatement();
		
		}catch(Exception ex)
		{
			System.out.println("Error "+ ex);
		}
		
	}
	
	public boolean checkDetalis(String username,String password)
	{
		try {

			String query =("select * from login");
			//Execute SQL query
			rs=st.executeQuery(query);
			while(rs.next()) {
				
				if(rs.getString("Username").equals(username)&&
						rs.getString("Password").equals(password))
				{
					return true;
				}
				
				
			}
		}catch(Exception ex)
		{
			System.out.println("Error "+ ex);
		}
		return false;
	}
	
}
