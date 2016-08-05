package joshuaproject.tablemodel;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import joshuaproject.implementations.Religion;
import joshuaproject.implementations.ReligionDAO;

	/**
	 * Written 30 June 2016 by Heng L. Lam
	 */
public class RelModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int ID_COL = 0;
	private static final int REL_COL = 1;
	private static final int POP_COL = 2;
	private static final int CPC_COL = 3;
	private static final int CU_COL = 4;
	private static final int PCTU_COL = 5;
	private static final int POPU_COL = 6;
	private static final int PPOPU_COL = 7;
	private String[] genColumnNames = {"rlg", "religion", "population", "cntpeopctry", "cntunreach", "pctunreach", "popunreach", "pctpopunreach"};
	private String[] serColumnNames;
	private List<Object> ls;
	private ReligionDAO dao;
	
	public RelModel(List<Object> ls) {
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
		Religion rel = (Religion) ls.get(rowIndex);
		switch (columnIndex) {
		/* <-- implementation needed --> */
		case ID_COL:
			return rel.getRlg();
		case REL_COL:
			return rel.getReligion();
		case POP_COL:
			return rel.getPopulation();
		case CPC_COL:
			return rel.getCntpeopctry();
		case CU_COL:
			return rel.getCntunreach();
		case PCTU_COL:
			return rel.getPctunreach();
		case POPU_COL:
			return rel.getPopunreach();
		case PPOPU_COL:
			return rel.getPctpopunreach();
		default:
			return rel.getRlg();
		}
	}
	
	@Override
	public String getColumnName(int col) {
		return genColumnNames[col];
	}

	public String getSerialColName(int col) {
//		return genColumnNames[col];
		return genColumnNames[col];
	}
	
	public void setDAO(ReligionDAO rel) {
		try {
			serColumnNames = rel.getSerialColNames();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.dao = rel;
	}

	public ReligionDAO getDAO()
	{
		return dao;
	}
	
	public RelModel getModel()
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
