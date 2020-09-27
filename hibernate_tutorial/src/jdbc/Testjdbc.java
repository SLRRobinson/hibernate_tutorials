package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/clientsDatabase?useSSL=true&serverTimezone=UTC";
		String user="Robinson";
		// Robinson is one of the users of cilentDatabase
		String pass="okav,1970";
		//  Robinson's password for clientsDatabase is the above pass variable value.
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
