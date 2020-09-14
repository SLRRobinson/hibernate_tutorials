package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/clientsDatabase?useSSL=true&serverTimezone=UTC";
		String user="Robinson";
		String pass="okav,1970";
		try {
			System.out.println("Connecting to database" + jdbcUrl);
			Connection myConn=DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful");
		}
catch (Exception exc) {
	exc.printStackTrace();
}
	}

}
