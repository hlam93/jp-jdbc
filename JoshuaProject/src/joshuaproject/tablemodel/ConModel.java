package joshuaproject.tablemodel;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import joshuaproject.implementations.Continent;
import joshuaproject.implementations.ContinentDAO;

	/**
	 * Written 30 June 2016 by Heng L. Lam
	 */
public class ConModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int ID_COL = 0;
	private static final int CON_COL = 1;
	private static final int TC_COL = 2;
	private static final int POP_COL = 3;
	private static final int PEOP_COL = 4;
	private static final int UPEOP_COL = 5;
	private static final int PCTUPEOP_COL = 6;
	private static final int POPU_COL = 7;
	private static final int PCTPOPU_COL = 8;
	private static final int TENFORTY_COL = 9;
	private static final int PCTCH_COL = 10;
	private static final int PCTE_COL = 11;
	private static final int PCTURB_COL = 12;
	
	private String[] genColumnNames = {"id", "continent", "totalcountries", "population", "peoples", "unreachedpeoples",
										"pctunreachedpeoples", "populationunreached", "pctpopulationunreached", "tenforty",
										"pctchristian", "pctevangelical", "pcturbanized"};
	private String[] serColumnNames;
	private List<Object> ls;
	private ContinentDAO dao;
	
	public ConModel(List<Object> list) {
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
		 Continent con = (Continent) ls.get(rowIndex);
		 switch (columnIndex) {
		 case ID_COL:
			 return con.getId();
		 case CON_COL:
			 return con.getContinent();
		 case TC_COL:
			 return con.getTotalcountries();
		 case POP_COL:
			 return con.getPopulation();
		 case PEOP_COL:
			 return con.getPeoples();
		 case UPEOP_COL:
			 return con.getUnreachedpeoples();
		 case PCTUPEOP_COL:
			 return con.getPctunreachedpeoples();
		 case POPU_COL:
			 return con.getPopulationunreached();
		 case PCTPOPU_COL:
			 return con.getPctpopulationunreached();
		 case TENFORTY_COL:
			 return con.getTenforty();
		 case PCTCH_COL:
			 return con.getPctchristian();
		 case PCTE_COL:
			 return con.getPctevangelical();
		 case PCTURB_COL:
			 return con.getPcturban(); 
		 }
		return null;
	}

	public String getColumnName(int col) {
		return genColumnNames[col];
	}

	public String getSerialColName(int col) {
		return genColumnNames[col];
	  //  return serColumnNames[col];
	}
	
	public void setDAO(ContinentDAO con) {
		this.dao = con;
	}
	
	public ContinentDAO getDAO() {
		return dao;
	}
	
	public ConModel getModel() {
		return this;
	}
	
	public String getHeader() {
		String header = Arrays.toString(genColumnNames);
		/* Trim beginning and ending brackets */
		header = header.substring(1, header.length() - 1);
		return header;
	}
}
