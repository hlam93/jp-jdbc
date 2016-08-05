package joshuaproject.framework;

	/**
	 * Written 30 June 2016 by Heng L. Lam
	 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public abstract class GlobalDAO {
	private static Connection myConn = null; /* singular global connection access */

	protected void connect() throws FileNotFoundException, IOException {
	   /**
	    * Use this code when developing in IDE 
		* Properties prop = new Properties();
		* prop.load(new FileInputStream("joshuaproject.properties"));
		* String dburl = prop.getProperty("dburl");
		**/
		
		/* Use this line to export to runnable jar file*/
		String dburl = "jdbc:sqlite::resource:sqlitedb/joshuaproject.db";
		
		if (myConn == null){
			try {
				myConn = DriverManager.getConnection(dburl);
				System.out.println("Successful connection established to " + dburl);
			} catch (SQLException e) {
				System.out.println("Failed to connect to " + dburl);
			}
		}
		else
			System.out.println("Connection already established to " + dburl);
	}
	
	protected Connection getConnection()
	{
		return myConn;
	}

	/* auxiliary helper methods */
	public abstract void printAll() throws Exception;

	public abstract List<Object> search(String input, String sortByName, String dir) throws Exception;
	
	public abstract List<Object> sort(String serialColName, String dir) throws Exception;
	
	protected void close(Statement st, ResultSet rs) throws SQLException
	{
		st.close(); rs.close();
	}
}