package joshuaproject.tablemodel;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import joshuaproject.implementations.Region;
import joshuaproject.implementations.RegionDAO;

	/**
	 * Written 30 June 2016 by Heng L. Lam
	 */
public class RegModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int ID_COL = 0;
	private static final int REG_COL = 1;
	private static final int CC_COL = 2;
	private static final int POP_COL = 3;
	private static final int CPC_COL = 4;
	private static final int CU_COL = 5;
	private static final int PUR_COL = 6;
	private static final int POPU_COL = 7;
	private static final int PPOPU_COL = 8;
	private static final int PCTU_COL = 9;
	
	private String[] genColumnNames = {"regioncode", "name", "cntcountry", "population", "cntpeopctry",
			"cntunreach", "pctunreach", "popunreach", "pctpopunreach", "pcturban"};
	private String[] serColumnNames;
	private List<Object> ls;
	private RegionDAO dao;

	public RegModel(List<Object> ls) {
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
		Region reg = (Region) ls.get(rowIndex);
		/* <-- implementation needed --> */
		switch (columnIndex) {
		case ID_COL:
			return reg.getCode();
		case REG_COL:
			return reg.getName();
		case CC_COL:
			return reg.getCntctry();
		case POP_COL:
			return reg.getPopulation();
		case CPC_COL:
			return reg.getCntpeopctry();
		case CU_COL:
			return reg.getCntunreach();
		case PUR_COL:
			return reg.getPctunreach();
		case POPU_COL:
			return reg.getPopunreach();
		case PPOPU_COL:
			return reg.getPctpopunreach();
		case PCTU_COL:
			return reg.getPcturban();
		}
		return null;
	}

	public String getColumnName(int col)
	{
		return genColumnNames[col];
	}
	
	public String getSerialColName(int col)
	{
		return genColumnNames[col];
//		return serColumnNames[col];
	}
	
	public void setDAO(RegionDAO reg) {
		try {
			serColumnNames = reg.getSerialColNames();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.dao = reg;
	}

	public RegionDAO getDAO()
	{
		return this.dao;
	}

	public RegModel getModel()
	{
		return this;
	}
	
	public String getHeader() {
		String header = Arrays.toString(genColumnNames);
		/* Trim beginning and ending brackets */
		header = header.substring(1, header.length() - 1);
		return header;
	}
}
