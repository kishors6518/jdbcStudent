package jdbcStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentUpdate {

	public static void main(String[] args)throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Name");
		String name=scanner.nextLine();
		System.out.println("Enter Father Name");
		String fath=scanner.nextLine();
		System.out.println("Enter Mother Name");
		String	moth=scanner.nextLine();
		System.out.println("Enter address");
		String add=scanner.nextLine();
//		System.out.println("Enter Phone Number");
		//long phno=scanner.nextLong();
		System.out.println("Enter Id");
		int id=scanner.nextInt();
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String user="root";
		String pass="root";
		String sqlUpdate="UPDATE STUDENT SET STUDENTNAME=?, FATHERNAME=?, MOTHERNAME=?, ADDRESS=? Where Id=?";
		
		Class.forName(className);
		
		Connection connection=DriverManager.getConnection(url, user, pass);
		
		PreparedStatement preparedStatement=connection.prepareStatement(sqlUpdate);
		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, fath);
		preparedStatement.setString(3, moth);
		preparedStatement.setString(4, add);
	   preparedStatement.setInt(5, id);
		
		int result=preparedStatement.executeUpdate();
		
		if(result!=0)
		{
			System.out.println("Data Updated");
		}
		else
		{
			System.out.println("Data not Updated");
		}
		connection.close();		

		

	}

}
