package jdbcStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class FetchStudentData {

	public static void main(String[] args)throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter id");
		int id=scanner.nextInt();
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String user="root";
		String pass="root";
		String sqlFetch="Select * from student Where id=?";
		
		//1.Load Driver
		Class.forName(className);
		
		//2.Estatblish Connection
		Connection connection=DriverManager.getConnection(url, user, pass);
		
		//3.Create Statement
		PreparedStatement preparedStatement=connection.prepareStatement(sqlFetch);
		
		//4.Execute Statement
		preparedStatement.setInt(1, id);
		
		//5.Close connection
		connection.close();
		
		

	}

}
