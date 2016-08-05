package joshuaproject.implementations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import joshuaproject.framework.GlobalDAO;

	/**
	 * Written 30 June 2016 by Heng L. Lam
	 */

public class PeopleClusterDAO extends GlobalDAO {
	private Connection myConn;
	private ResultSetMetaData md;
	private List<Object> viewList;
	
	public PeopleClusterDAO () throws Exception {
		
		/*-------------------Lifted code block to superclass--------------------*/
		/*--------------------------------------------------------------------*/
		/* Checks for successful connection to DB */
		connect();
		myConn = getConnection();
		Statement st = myConn.createStatement();
		md = st.executeQuery("select * from peoplecluster").getMetaData();
		st.close();
	}
	
	/* method to return all */
	public List<Object> getAllItems() throws Exception {
		viewList = new ArrayList<Object>();
		
		Statement st = null;
		ResultSet rs = null;
		
		st = myConn.createStatement();
		rs = st.executeQuery("select * from peoplecluster");
//		rs = st.getResultSet();
		while (rs.next())
		{
			/* Convert row to instance of PeopleCluster */
			PeopleCluster pc = rowToPeopleCluster(rs);
			viewList.add(pc);
//			pc.print();
		}
		close(st, rs);
		return viewList;
	}
	
	/* methods to search */
	public List<Object> search(String input) throws Exception {
		viewList = new ArrayList<Object>();
		PreparedStatement st = null;
		ResultSet rs = null;
		input = "%" + input + "%";
		/* SQL sanitized */
		String sql = "select * from peoplecluster where peoplecluster like ?";
		st = myConn.prepareStatement(sql);
		/* Bind parameter */
		st.setString(1, input);
		st.executeQuery();
		rs = st.getResultSet();
		while(rs.next())
		{
			PeopleCluster pc = rowToPeopleCluster(rs);
			viewList.add(pc);
		}
		close(st, rs);
		return viewList;
	}

	public List<Object> search(String input, String sortByColumnName, String dir) throws Exception {
		viewList = new ArrayList<Object>();
		PreparedStatement st = null;
		ResultSet rs = null;
		input = "%" + input + "%";
		/* SQL sanitized */
		String sql = "select * from peoplecluster where peoplecluster like ? order by " + sortByColumnName + " " + dir;
		st = myConn.prepareStatement(sql);
		/* Bind parameter */
		st.setString(1, input);
		rs = st.executeQuery();
//		rs = st.getResultSet();
		while(rs.next())
		{
			PeopleCluster pc = rowToPeopleCluster(rs);
			viewList.add(pc);
		}
		close(st, rs);
		return viewList;
	}
	
	public List<Object> sort(String serialColName, String dir) throws Exception {
		viewList = new ArrayList<Object>();
		
		PreparedStatement st = null;
		ResultSet rs = null;
		/* SQL sanitized */
		String sql = "select * from peoplecluster ORDER BY " + serialColName + " " + dir;
		st = myConn.prepareStatement(sql);
		rs = st.executeQuery();
//		rs = st.getResultSet();
		while (rs.next())
		{
			PeopleCluster pc = rowToPeopleCluster(rs);
			viewList.add(pc);
		}
		close(st, rs);
		return viewList;
	}

	/* auxiliary helper methods */	
	private PeopleCluster rowToPeopleCluster (ResultSet rs) throws Exception
	{
		md = rs.getMetaData();
		PeopleCluster pc = new PeopleCluster(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5),
				rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9), rs.getDouble(10), rs.getDouble(11), rs.getDouble(12));
		return pc;
	}
	
	public String[] getSerialColNames () throws Exception {
//		System.out.println(md != null);
		/**
		 * (Unresolved)
		 * java.lang.IllegalStateException: SQLite JDBC: inconsistent internal state
		 * 
		 * md.getColumnCount(); <---- traced
		 * 
		 * <------------------------------------------------------------------------>
		 * Issue due to JAVA class ResultSetMetaData.class
		 * */
		String[] l = new String[12];
		for (int i = 1; i <= l.length; i++){
			l[i-1] = md.getColumnName(i);
		}
		String[] l2 = {l[0], l[1], l[2], l[3], l[4], l[5], l[6], l[7], l[8], l[9], l[10], l[11]};
		return l2;
	}
	
	@Override
	public void printAll() throws Exception {
		List<Object> ls = getAllItems();
		for (int i = 0; i < ls.size(); i++)
		{
			((PeopleCluster) ls.get(i)).print();
		}
	}
	
	public PeopleClusterDAO getDAO()
	{
		return this;
	}
	
	public List<Object> getList() {
		return viewList;
	}
}
