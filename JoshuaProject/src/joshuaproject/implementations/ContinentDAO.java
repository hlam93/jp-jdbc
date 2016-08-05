package joshuaproject.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import joshuaproject.framework.GlobalDAO;

public class ContinentDAO extends GlobalDAO {
	private Connection myConn;
	private ResultSetMetaData md;
	private List<Object> viewList;
	
	public ContinentDAO() throws Exception {
		connect();
		myConn = getConnection();
		Statement st = myConn.createStatement();
		md = st.executeQuery("select * from continent").getMetaData();
		st.close();
	}

	@Override
	public void printAll() throws Exception {
		List<Object> ls = getAllItems();
		for (int i = 0; i < ls.size(); i++)
		{
			((Continent) ls.get(i)).print();
		}
	}

	@Override
	public List<Object> search(String input, String sortByColumnName, String dir) throws Exception {
		viewList = new ArrayList<Object>();
		PreparedStatement st = null;
		ResultSet rs = null;
		input = "%" + input + "%";
		/* SQL sanitized */
		String sql = "select * from continent where continent like ? order by " + sortByColumnName + " " + dir;
		st = myConn.prepareStatement(sql);
		/* Bind parameter */
		st.setString(1, input);
		rs = st.executeQuery();
		while(rs.next())
		{
			Continent con = rowToContinent(rs);
			viewList.add(con);
		}
		close(st, rs);
		return viewList;
	}

	private Continent rowToContinent(ResultSet rs) throws Exception {
		Continent con = new Continent(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6),
									  rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getInt(10), rs.getDouble(11), rs.getDouble(12),//);
									  rs.getDouble(13));
		return con;
	}

	@Override
	public List<Object> sort(String serialColName, String dir) throws Exception {
		viewList = new ArrayList<Object>();
		
		PreparedStatement st = null;
		ResultSet rs = null;
		/* SQL sanitized */
		String sql = "select * from continent ORDER BY " + serialColName + " " + dir;
		st = myConn.prepareStatement(sql);
		rs = st.executeQuery();
		while (rs.next())
		{
			Continent con = rowToContinent(rs);
			viewList.add(con);
		}
		close(st, rs);
		return viewList;
	}

	public List<Object> getAllItems() throws Exception {
		viewList = new ArrayList<Object>();
		
		Statement st = null;
		ResultSet rs = null;
		
		st = myConn.createStatement();
		rs = st.executeQuery("select * from continent");
			
		while (rs.next())
		{
			/* Convert row to instance of PeopleCluster */
			Continent con = rowToContinent(rs);
			viewList.add(con);
		}
		close(st, rs);
		return viewList;
	}

	public String[] getSerialColNames () throws SQLException {
//		String[] l = new String[md.getColumnCount()];
		String[] l = new String[13];
		for (int i = 1; i <= l.length; i++){
			l[i-1] = md.getColumnName(i);
		}
		String[] l2 = {l[0], l[1], l[2], l[4], l[5], l[6], l[7], l[8], l[9], l[10], l[11], l[12]};
		return l2;
	}	

	public ContinentDAO getDAO() {
		return this;
	}
	public List<Object> getList() {
		return viewList;
	}
}
