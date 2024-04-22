package jdbcStudent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class StudentInsert {

	public static void main(String[] args)throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Student id");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Student name");
		String sName=scanner.nextLine();
		System.out.println("Enter Student Father name");
		String fName=scanner.nextLine();
		System.out.println("Enter Student Mother name");
		String mName=scanner.nextLine();
		System.out.println("Enter Student Address");
		String add=scanner.nextLine();
		System.out.println("Enter Phone number");
		long phno=scanner.nextLong();
		System.out.println("Enter Student marks");
		int mark=scanner.nextInt();
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String user="root";
		String pass="root";
		String sql="INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?)";
		
		//1. Load the Driver
		Class.forName(className);
		
		//2.Establish connection
		Connection connection=DriverManager.getConnection(url, user, pass);
		
		//3.Create Statement
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, sName);
		preparedStatement.setString(3, fName);
		preparedStatement.setString(4, mName);
		preparedStatement.setLong(5, phno);
		preparedStatement.setString(6, add);
		preparedStatement.setInt(7, mark);
		
		int result=preparedStatement.executeUpdate();
		
		if(result!=0)
		{
			System.out.println("Data Inserted");
		}
		else
		{
			System.out.println("Data not Inserted");
		}
		connection.close();		
		
		
		

	}

}
