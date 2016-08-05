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

	/**
	 * Written 30 June 2016 by Heng L. Lam
	 */

public class CountryDAO extends GlobalDAO {
	private Connection myConn;
	private ResultSetMetaData md;
	private List<Object> viewList;
	
	public CountryDAO() throws Exception {
		connect();
		myConn = getConnection();
		Statement st = myConn.createStatement();
		md = st.executeQuery("select * from country").getMetaData();
		st.close();
	}

	@Override
	public void printAll() throws Exception
	{
		List<Object> ls = getAllItems();
		for (int i = 0; i < ls.size(); i++)
		{
			((Country) ls.get(i)).print();
		}
	}

	/* methods to search */
	@Override
	public List<Object> search(String input, String sortByColumnName, String dir) throws Exception {
		viewList = new ArrayList<Object>();
		PreparedStatement st = null;
		ResultSet rs = null;
		input = "%" + input + "%";
		/* SQL sanitized */
		String sql = "select * from country where country like ? order by " + sortByColumnName + " " + dir;
		st = myConn.prepareStatement(sql);
		/* Bind parameter */
		st.setString(1, input);
		rs = st.executeQuery();
//		rs = st.getResultSet();
		while(rs.next())
		{
			Country pc = rowToCountry(rs);
			viewList.add(pc);
		}
		close(st, rs);
		return viewList;
	}

	/* auxiliary helper methods */
	private Country rowToCountry(ResultSet rs) throws SQLException
	{
		md = rs.getMetaData();

		Country country = new Country(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5),
				rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getInt(9), rs.getString(10), rs.getDouble(11),
				rs.getString(12), rs.getInt(13));
		return country;
	}
	
	@Override
	public List<Object> sort(String serialColName, String dir) throws Exception {
		List<Object> ls = new ArrayList<Object>();
		
		PreparedStatement st = null;
		ResultSet rs = null;
		/* SQL sanitized */
		String sql = "select * from country ORDER BY " + serialColName + " " + dir;
		st = myConn.prepareStatement(sql);
		rs = st.executeQuery();
//		rs = st.getResultSet();
		while (rs.next())
		{
			Country c = rowToCountry(rs);
			ls.add(c);
		}
		close(st, rs);
		return ls;
	}

	/* method to return all */
	public List<Object> getAllItems() throws Exception {
		List<Object> ls = new ArrayList<Object>();
		
		Statement st = null;
		ResultSet rs = null;
		
		st = myConn.createStatement();		
		rs = st.executeQuery("select * from country");
//		rs = st.getResultSet();
		
		while (rs.next())
		{
			Country country = rowToCountry(rs);
			ls.add(country);
//			country.print();
		}
		close(st, rs);
		return ls;
	}

	public String[] getSerialColNames () throws SQLException
	{
//		String[] l = new String[md.getColumnCount()];
		String[] l = new String[13];
		for (int i = 1; i <= l.length; i++){
//			l[i-1] = this.md.getColumnName(i);
		}
//		String[] l2 = {l[0], l[1], l[2], l[4], l[5], l[6], l[7], l[8], l[9], l[10], l[11], l[12]};
		String[] l2 = {l[0], l[1], l[2], l[3], l[4], l[5], l[6], l[7], l[8], l[9], l[10], l[11], l[12]};
		return l2;
	}

	public CountryDAO getDAO()
	{
		return this;
	}

	public List<Object> getList() {
		return viewList;
	}
}
