package joshuaproject.tablemodel;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import joshuaproject.implementations.Affinity;
import joshuaproject.implementations.AffinityDAO;
import joshuaproject.implementations.Continent;

	/**
	 * Written 30 June 2016 by Heng L. Lam
	 */
public class AffModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int ID_COL = 0;
	private static final int AFF_COL = 1;
	private static final int POP_COL = 2;
	private static final int CPC_COL = 3;
	private static final int CPEPC_COL = 4;
	private static final int CPCT_COL = 5;
	private static final int CL_COL = 6;
	private static final int PCTL_COL = 7;
	private static final int POPLST_COL = 8;
	private static final int PPOPL_COL = 9;
	private String[] genColumnNames = {"peopleid", "affinity", "sum_pop", "count_pc", "count_peop", "count_pctry", "count_least",
			"pctleast", "sum_pop_least", "pctpopleast"};
	private String[] serColumnNames;
	private List<Object> ls;
	private AffinityDAO dao;
	
	public AffModel(List<Object> ls) {
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
	
	public String getColumnName(int col) {
		return genColumnNames[col];
	}
	
	public String getSerialColName(int col) {
		return genColumnNames[col];
	  //  return serColumnNames[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		 Affinity aff = (Affinity) ls.get(rowIndex);
		 switch (columnIndex) {
			case ID_COL:
				return aff.getPeopleId();
			case AFF_COL:
				return aff.getAffinity();
			case POP_COL:
				return aff.getPopulation();
			case CPC_COL:
				return aff.getCountPC();
			case CPEPC_COL:
				return aff.getCountPCountry();
			case CPCT_COL:
				return aff.getCountPE();
			case CL_COL:
				return aff.getCountLeast();
			case PCTL_COL:
				return aff.getPctLeast();
			case POPLST_COL:
				return aff.getSumPopLeast();
			case PPOPL_COL:
				return aff.getPctPopLeast();
			default:
				return aff.getPeopleId();	 
		 }
	}

	public AffinityDAO getDAO() {
		return this.dao;
	}
	public void setDAO(AffinityDAO aff) {
		try { this.serColumnNames = aff.getSerialColNames();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.dao = aff;
	}

	public String getHeader() {
		String header = Arrays.toString(genColumnNames);
		/* Trim beginning and ending brackets */
		header = header.substring(1, header.length() - 1);
		return header;
	}

}
