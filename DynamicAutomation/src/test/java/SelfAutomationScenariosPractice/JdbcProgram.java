package SelfAutomationScenariosPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import GenericUtility.JavaUtility;

public class JdbcProgram {


	@Test
	public void addData() throws SQLException
	{
		// register / load databases
		JavaUtility ju = new JavaUtility();
		int ran=ju.getRandomNum();
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		
		// get connection to databases
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		
		// create sql statement
		Statement statement = con.createStatement();
		String query = "insert into engineer(name,department,salary)value('Rajesh"+ran+"','IT', '"+ran+"')";
		String query1 = "select * from engineer";

		// execute query
		int result = statement.executeUpdate(query);
		 ResultSet result1 = statement.executeQuery(query1);
		 
		 if(result==1)
		 {
			 System.out.println("Data updated");
		 }
		while(result1.next())
		{
			System.out.println(result1.getString(1)+"\t"+ result1.getString(2)+"\t"+ result1.getInt(3));
		}
	}
}
