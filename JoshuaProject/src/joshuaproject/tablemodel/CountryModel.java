package joshuaproject.tablemodel;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import joshuaproject.implementations.Country;
import joshuaproject.implementations.CountryDAO;

	/**
	 * Written 30 June 2016 by Heng L. Lam
	 */
public class CountryModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int ROG_COL = 0;
	private static final int C_COL = 1;
	private static final int CP_COL = 2;
	private static final int CU_COL = 3;
	private static final int POP_COL = 4;
	private static final int POPU_COL = 5;
	private static final int PPU_COL = 6;
	private static final int PEPU_COL = 7;
	private static final int SEC_COL = 8;
	private static final int REL_COL = 9;
	private static final int PCTE_COL = 10;
	private static final int WIN_COL = 11;
	private static final int PCTU_COL = 12;
	
//	private String[] genColumnNames = {"ROG", "Country", "CountPeople", "CountUnreach", "Population", "PopulationUnreach",
//			"PctPopUnreach", "PctPeopleUnreach", "SecurityLvl", "Religion", "PctEvangelical", "Win1040", "PctUrban"};
	private String[] serColumnNames;
	private String[] genColumnNames = {"ROG", "country", "cntpeoples", "cntunreach", "population", "popunreach", "pctpopunreach",
			"pctpeopleunreach", "securitylvl", "religion", "pctevangelical", "win1040", "pcturban"}; 
	private List<Object> ls;
	private CountryDAO dao;
	
	public CountryModel (List<Object> ls)
	{
		this.ls = ls;
	}
	
	@Override
	public int getRowCount() {
		return ls.size();
	}

	@Override
	public int getColumnCount() {
		return genColumnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Country o = (Country) ls.get(rowIndex);
		switch (columnIndex) {
		case ROG_COL:
			return o.getRog();
		case C_COL:
			return o.getCountry();
		case CP_COL:
			return o.getCntpeoples();
		case CU_COL:
			return o.getCntunreach();
		case POP_COL:
			return o.getPopulation();
		case POPU_COL:
			return o.getPopunreach();
		case PPU_COL:
			return o.getPctpopunreach();
		case PEPU_COL:
			return o.getPctpeopleunreach();
		case SEC_COL:
			return o.getSecuritylvl();
		case REL_COL:
			return o.getReligion();
		case PCTE_COL:
			return o.getPctevangelical();
		case WIN_COL:
			return o.getWin1040();
		case PCTU_COL:
			return o.getPcturban();
		default:
			return o.getCountry();
		}
	}
	
	public String getColumnName(int col) {
		return genColumnNames[col];
	}

	public String getSerialColName(int col) {
//		return serColumnNames[col];
		return genColumnNames[col];
	}

	public void setDAO(CountryDAO dao) {
		try {
			this.serColumnNames = dao.getSerialColNames();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.dao = dao;
	}

	public CountryDAO getDAO() {
		return dao;
	}

	public CountryModel getModel()	{
		return this;
	}
	
	public String getHeader() {
		String header = Arrays.toString(genColumnNames);
		/* Trim beginning and ending brackets */
		header = header.substring(1, header.length() - 1);
		return header;
	}

}
