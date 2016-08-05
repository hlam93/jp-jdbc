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

public class RegionDAO extends GlobalDAO {
	private Connection myConn;
	private ResultSetMetaData md;
	private List<Object> viewList;
	
	public RegionDAO() throws Exception {
		connect();
		myConn = getConnection();
	}

	@Override
	public void printAll() throws Exception {
		List<Object> ls = getAllItems();
		for (int i = 0; i < ls.size(); i++)
		{
			((Region) ls.get(i)).print();
		}
	}

	@Override
	public List<Object> search(String input, String sortByColumnName, String dir) throws Exception {
		viewList = new ArrayList<Object>();
		PreparedStatement st = null;
		ResultSet rs = null;
		input = "%" + input + "%";
		/* SQL sanitized */
		String sql = "select * from region where name like ? order by " + sortByColumnName + " " + dir;
		st = myConn.prepareStatement(sql);
		/* Bind parameter */
		st.setString(1, input);
		rs = st.executeQuery();
//		rs = st.getResultSet();
		while(rs.next())
		{
			Region reg = rowToRegion(rs);
			viewList.add(reg);
		}
		close(st, rs);
		return viewList;
	}

	@Override
	public List<Object> sort(String serialColName, String dir) throws Exception {
		List<Object> ls = new ArrayList<Object>();
		
		PreparedStatement st = null;
		ResultSet rs = null;
		/* SQL sanitized */
		String sql = "select * from region ORDER BY " + serialColName + " " + dir;
		st = myConn.prepareStatement(sql);
		rs = st.executeQuery();
//		rs = st.getResultSet();
		while (rs.next())
		{
			Region reg = rowToRegion(rs);
			ls.add(reg);
		}
		close(st, rs);
		return ls;
	}

	public List<Object> getAllItems() throws Exception {
		List<Object> ls = new ArrayList<Object>();
		
		Statement st = null;
		ResultSet rs = null;
		
		st = myConn.createStatement();
		rs = st.executeQuery("select * from region");
			
//		rs = st.getResultSet();
		while (rs.next())
		{
			/* Convert row to instance of PeopleCluster */
			Region pc = rowToRegion(rs);
			ls.add(pc);
		}
		close(st, rs);
		return ls;
	}

	private Region rowToRegion(ResultSet rs) throws Exception {
		md = rs.getMetaData();
		/* <-- implementation needed --> */
		Region reg = new Region(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5),
				rs.getInt(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10));
		return reg;
	}

	public String[] getSerialColNames () throws SQLException {
//		String[] l = new String[md.getColumnCount()];
		String[] l = new String[10];
		for (int i = 1; i <= l.length; i++){
//			l[i-1] = md.getColumnName(i);
		}
		String[] l2 = {l[0], l[1], l[2], l[4], l[5], l[6], l[7], l[8], l[9]};
		return l2;
	}
	
	public RegionDAO getDAO() {
		return this;
	}
	
	public List<Object> getList() {
		return viewList;
	}
}
