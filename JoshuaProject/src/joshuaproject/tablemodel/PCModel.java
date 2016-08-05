package joshuaproject.tablemodel;

import javax.swing.table.AbstractTableModel;

import joshuaproject.implementations.*;

import java.sql.SQLException;
import java.util.*;

	/**
	 * Written 30 June 2016 by Heng L. Lam
	 */
public class PCModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int ID_COL = 0;
	private static final int PC_COL = 1;
	private static final int PS_COL = 2;
	private static final int PCH_COL = 3;
	private static final int PCE_COL = 4;
	private static final int PR_COL = 5;
	private static final int POP_COL = 6;
	private static final int PEOP_COL = 7;
	private static final int PEOPU_COL = 8;
	private static final int PPU_COL = 9;
	private static final int POPU_COL = 10;
	private static final int PCTPOPU_COL = 11;

	/* column names displayed to GUI */
	private String[] genColumnNames = {"id", "peoplecluster", "progress","pctchristian", "pctevangelical", "religion",
										"population", "peoples", "peoplesUnreached", "pctpeoplesUnreached", "populationUnreached", "pctpopulationUnreached"};
	/* column names from database */
	private String[] serColumnNames;
	private List<Object> ls;
	private PeopleClusterDAO dao;
	
	public PCModel (List<Object> list) {
		this.ls = list;
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
		PeopleCluster pc = (PeopleCluster) ls.get(rowIndex);
		switch (columnIndex) {
		case ID_COL:
			return pc.getId();
		case PC_COL:
			return pc.getName();
		case PS_COL:
			return pc.getProgressScale();
		case PCH_COL:
			return pc.getPercentChristian();
		case PCE_COL:
			return pc.getPercentEvangelical();
		case PR_COL:
			return pc.getPrimaryReligion();
		case POP_COL:
			return pc.getPopulation();
		case PEOP_COL:
			return pc.getPeoples();
		case PEOPU_COL:
			return pc.getPeoplesUnreached();
		case PPU_COL:
			return pc.getPercentPeoplesUnreached();
		case POPU_COL:
			return pc.getPopUnreached();
		case PCTPOPU_COL:
			return pc.getPercentPopUnreached();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int col) {
		return genColumnNames[col];
	}

	public String getSerialColName(int col) {
		/**
		 * (Unresolved)
		 * java.lang.IllegalStateException: SQLite JDBC: inconsistent internal state
		 * 
		 * return serColumnNames[col];
		 */
		/* alternative fix
		 * 
		 * all generic column names exactly like serial column names
		 * */
		return genColumnNames[col];
	}

	public void setDAO(PeopleClusterDAO pc) throws Exception {
		/**
		 * (Unresolved)
		 * java.lang.IllegalStateException: SQLite JDBC: inconsistent internal state
		 *
		 * try {
		 *   serColumnNames = pc.getSerialColNames(); <----- traced
		 * } catch (SQLException e) {
		 *     e.printStackTrace();
		 * }
		 **/
		this.dao = pc;
	}
	
	public PeopleClusterDAO getDAO() {
		return dao;
	}

	public PCModel getModel() {
		return this;
	}

	public String getHeader() {
		String header = Arrays.toString(genColumnNames);
		/* Trim beginning and ending brackets */
		header = header.substring(1, header.length() - 1);
		return header;
	}
}
