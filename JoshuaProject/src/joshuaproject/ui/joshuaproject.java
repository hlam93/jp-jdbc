package joshuaproject.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import joshuaproject.framework.GlobalDAO;
import joshuaproject.implementations.*;
import joshuaproject.tablemodel.*;
import joshuaproject.util.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButtonMenuItem;

	/**
	 * @author heng
	 * 
	 * IDE Eclipse Mars 2.0 (4.5.2)
	 * version 0.1
	 * Generated 30 June 2016 by Heng L. Lam
	 * Created using a framework-based design for structural efficiency and abstraction
	 * 
	 * Implementation designed using:
	 * 	1.  Object Oriented Programming
	 *  2.  SQLite3
	 *  3.  WindowBuilder 
	 *  
	 * Simple program that allows the user to view data using:
	 * 	- MySQL Server for the back-end
	 *  - WindowBuilder for the front-end
	 * 
	 * Data from https://joshuaproject.net
	 * 
	 * References:
	 *  - https://www.youtube.com/user/luv2codetv/playlists <JDBC playlist>
	 *  - https://bitbucket.org/xerial/sqlite-jdbc <SQLite manual>
	 *  - https://examples.javacodegeeks.com/core-java/writeread-csv-files-in-java-example/ <CSV migration>
	 *  
	 *  <------------------ need to implement ------------------>
	 *  a. Install into database schema:
	 *  	CREATE TABLE <table_name> (<colname> <coltype>, ... <colname3> <coltype>);
	 *  	- Country table
	 *  	- Region table
	 *  	- Religion table
	 *  	- Affinity table
	 *  b. Implement getValueAt() methods for joshuaproject.tablemodels.*
	 *  c. Implement CSVFile.writeToCSV() methods for joshuaproject.util
	 *  
	 * */

public class joshuaproject {	
	private JFrame frmJoshuaproject;
	
	private GlobalDAO gDAO;	private PeopleClusterDAO pc; private CountryDAO c; private ReligionDAO rel;
	private RegionDAO reg; private ContinentDAO con; private AffinityDAO aff;
	
	private PCModel pcm; private CountryModel tcm; private ConModel cm; private RelModel relm; private RegModel regm; private AffModel afm;
	
	private JTable resultTable;
	private JTextField searchTextField;
	private JLabel lblStatusLabel;
	private JPanel selectPanelLabel;
	private JLabel selectPanelField;
	private int currentDataSet = 0;
	private String dir;
	private String sortByColumnName;
	private static final int PEOPLECLUSTER = 1;
	private static final int COUNTRY = 2;
	private static final int RELIGION = 3;
	private static final int REGION = 4;
	private static final int CONTINENT = 5;
	private static final int AFFINITY = 6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					joshuaproject window = new joshuaproject();
					window.frmJoshuaproject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public joshuaproject() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frmJoshuaproject = new JFrame();
		frmJoshuaproject.setResizable(false);
		frmJoshuaproject.setTitle("JoshuaProjectViewer");
		frmJoshuaproject.setBounds(100, 100, 946, 404);
		frmJoshuaproject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblStatusLabel = new JLabel("Status:");
		JMenuBar menuBar = new JMenuBar();
		frmJoshuaproject.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(mnMenu);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJoshuaproject.dispose();
			}
		});

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setEnabled(false);
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveView();
			}
		});
		mnMenu.add(mntmSave);
		mnMenu.add(mntmClose);
		
		JMenu mnDataset = new JMenu("Select Dataset");
		mnDataset.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(mnDataset);
		frmJoshuaproject.getContentPane().setLayout(null);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(124, 0, 820, 20);
		frmJoshuaproject.getContentPane().add(searchTextField);
		searchTextField.setHorizontalAlignment(SwingConstants.LEFT);
		searchTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 21, 944, 309);
		frmJoshuaproject.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 943, 309);
		panel.add(scrollPane);
		
		resultTable = new JTable();
		scrollPane.setViewportView(resultTable);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				/* <----code extracted to doSearch()----> */
				doSearch();
			}
		});
		btnSearch.setBounds(0, 0, 122, 19);
		frmJoshuaproject.getContentPane().add(btnSearch);
		
		lblStatusLabel.setBounds(7, 335, 925, 15);
		frmJoshuaproject.getContentPane().add(lblStatusLabel);
		
		JMenu mnSortBy = new JMenu("Sort By");
		mnSortBy.setEnabled(false);
		menuBar.add(mnSortBy);

		selectPanelLabel = new JPanel();
		menuBar.add(selectPanelLabel);
		selectPanelLabel.setLayout(null);
		
		selectPanelField = new JLabel("None Selected");
		selectPanelField.setBounds(595, 3, 103, 15);
		selectPanelLabel.add(selectPanelField);
		selectPanelField.setFont(new Font("SansSerif", Font.PLAIN, 12));
		selectPanelField.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JMenuItem mntmPeoplecluster = new JMenuItem("PeopleCluster");
		mntmPeoplecluster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Update selection field */
				currentDataSet = PEOPLECLUSTER;
				selectPanelField.setText("PeopleCluster");
				/* <----code extracted to load()----> */
				load(mnSortBy);
				mntmSave.setEnabled(true);
			}
		});
		mnDataset.add(mntmPeoplecluster);
		
		JMenuItem mntmCountry = new JMenuItem("Country");
//		mntmCountry.setEnabled(false);
		mntmCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Update selection field */
				currentDataSet = COUNTRY;
				selectPanelField.setText("Country");
				/* <----code extracted to load()----> */
				load(mnSortBy);
				mntmSave.setEnabled(true);
			}
		});
		mnDataset.add(mntmCountry);
		
		JMenuItem mntmReligion = new JMenuItem("Religion");
//		mntmReligion.setEnabled(false);
		mntmReligion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDataSet = RELIGION;
				selectPanelField.setText("Religion");
				load(mnSortBy);
				mntmSave.setEnabled(true);
			}
		});
		mnDataset.add(mntmReligion);
		
		JMenuItem mntmRegion = new JMenuItem("Region");
//		mntmRegion.setEnabled(false);
		mntmRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDataSet = REGION;
				selectPanelField.setText("Region");
				load(mnSortBy);
				mntmSave.setEnabled(true);
			}
		});
		mnDataset.add(mntmRegion);
		
		JMenuItem mntmContinent = new JMenuItem("Continent");
		mntmContinent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDataSet = CONTINENT;
				selectPanelField.setText("Continent");
				load(mnSortBy);
				mntmSave.setEnabled(true);
			}
		});
		mnDataset.add(mntmContinent);
		
		JMenuItem mntmAffinity = new JMenuItem("Affinity");
//		mntmAffinity.setEnabled(false);
		mntmAffinity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDataSet = AFFINITY;
				selectPanelField.setText("Affinity");
				load(mnSortBy);
				mntmSave.setEnabled(true);
			}
		});
		mnDataset.add(mntmAffinity);
	}

	protected void saveView() {
		switch(currentDataSet) {
		case PEOPLECLUSTER:
			CSVFile.writeToCSV(pcm, "file.csv");
			break;
		case COUNTRY:
			CSVFile.writeToCSV(tcm, "file.csv");
			break;
		case RELIGION:
			CSVFile.writeToCSV(relm, "file.csv");
			break;
		case REGION:
			CSVFile.writeToCSV(regm, "file.csv");
			break;
		case CONTINENT:
			CSVFile.writeToCSV(cm, "file.csv");
			break;
		case AFFINITY:
			CSVFile.writeToCSV(afm, "file.csv");
			break;
		}
		lblStatusLabel.setText("Status: successfully saved as file.csv");
	}

	/* sort menu at runtime */
	private void createSortMenu(JMenu sort, AbstractTableModel atm)
	{
		dir = "asc";
		/* ascending radio button */
		JRadioButtonMenuItem rdbtnmntmAsc = new JRadioButtonMenuItem("ASC");
		rdbtnmntmAsc.setSelected(true);
		rdbtnmntmAsc.setBounds(-2, 1, 50, 19);

		/* descending radio button */
		JRadioButtonMenuItem rdbtnmntmDesc = new JRadioButtonMenuItem("DESC");
		rdbtnmntmDesc.setBounds(47, 1, 64, 19);
		
		rdbtnmntmDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSortDirection("desc");
				rdbtnmntmAsc.setSelected(false);
				rdbtnmntmDesc.setSelected(true);
			}
		});
		rdbtnmntmAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSortDirection("asc");
				rdbtnmntmDesc.setSelected(false);
				rdbtnmntmAsc.setSelected(true);
			}
		});
		selectPanelLabel.add(rdbtnmntmAsc);
		selectPanelLabel.add(rdbtnmntmDesc);
		
		sort.removeAll();
		int size = atm.getColumnCount();
		JMenuItem item = null;
		for (int i = 0; i < size; i++){
			int colID = i;
			item = new JMenuItem(atm.getColumnName(colID));
			item.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					viewSortTable(currentDataSet, colID, atm, dir);
				}
			});
			sort.add(item);
		}
	}

	/* auxiliary methods for sort menu */
	private void setSortDirection(String direction)	{ dir = direction; }

	private void viewSortTable(int currentDataSet, int colID, AbstractTableModel atm, String dir)
	{
		List<Object> ls;
		switch(currentDataSet) {
		case PEOPLECLUSTER:
		{
			PCModel tpc = (PCModel) getModelType(atm);
			PeopleClusterDAO dao = tpc.getDAO();
			try {
				ls = dao.sort(tpc.getSerialColName(colID), dir);
				pcm = new PCModel(ls); pcm.setDAO(dao);
				sortByColumnName = tpc.getSerialColName(colID);
				resultTable.setModel(pcm);
			} catch (Exception e1) {
				e1.printStackTrace();
			} break;				
		}
		case COUNTRY:
			CountryModel tc = (CountryModel) getModelType(atm);
			CountryDAO cdao = tc.getDAO();
			try {
				ls = cdao.sort(tc.getSerialColName(colID), dir);
				tcm = new CountryModel(ls); tcm.setDAO(cdao);
				sortByColumnName = tc.getSerialColName(colID);
				resultTable.setModel(tcm);
			} catch (Exception e1) {
				e1.printStackTrace();
			} break;
		case RELIGION:
		{
			RelModel rl = (RelModel) getModelType(atm);
			ReligionDAO rel = rl.getDAO();
			try {
				ls = rel.sort(rl.getSerialColName(colID), dir);
				relm = new RelModel(ls); relm.setDAO(rel);
				sortByColumnName = rl.getSerialColName(colID);
				resultTable.setModel(relm);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} break;
		case REGION:
		{
			RegModel rg = (RegModel) getModelType(atm);
			RegionDAO reg = rg.getDAO();
			try {
				ls = reg.sort(rg.getSerialColName(colID), dir);
				regm = new RegModel(ls); regm.setDAO(reg);
				sortByColumnName = rg.getSerialColName(colID);
				resultTable.setModel(regm);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} break;
		case CONTINENT:
			ConModel cml = (ConModel) getModelType(atm);
			ContinentDAO con = cml.getDAO();
			try {
				ls = con.sort(cml.getSerialColName(colID), dir);
				cm = new ConModel(ls); cm.setDAO(con);
				sortByColumnName = cm.getSerialColName(colID);
				resultTable.setModel(cm);
			} catch (Exception eq) {
				eq.printStackTrace();
			} break;
		case AFFINITY:
		{
			AffModel affm = (AffModel) getModelType(atm);
			AffinityDAO aff = affm.getDAO();
			try {
				ls = aff.sort(affm.getSerialColName(colID), dir);
				afm = new AffModel(ls); afm.setDAO(aff);
				sortByColumnName = affm.getSerialColName(colID);
				resultTable.setModel(afm);
				
			} catch (Exception eq) {
				eq.printStackTrace();
			} break;
		}
		default:
		}
	}
	
	private void doSearch()
	{	/* get user input */
		String input = searchTextField.getText();
		try {
			/* switches to correct DAO */
			gDAO = getDAO(currentDataSet);
			
			List<Object> ls;

			/* search DB with user input */ 
			ls = gDAO.search(input, sortByColumnName, dir);

			/* check for results */
			boolean b = (ls.isEmpty()) ? false : true;
			
			AbstractTableModel atm;

			/* search results returned */
			if (b)
			{	/* update status label appropriately */
				if (input.length() > 0) { lblStatusLabel.setText("Status: search results returned for " + input); }
				else { lblStatusLabel.setText("Status:"); }

				/* switch to correct ATM for viewing results */
				atm = getModel(currentDataSet, ls);
				resultTable.setModel(atm);
			}
			/* no search results returned */
			else
				lblStatusLabel.setText("Status: no results found");
		} catch (Exception e1) {
			lblStatusLabel.setText("Status: error 101! please load dataset");
			e1.printStackTrace();
		}
	}

	private void load(JMenu mnSortBy)
	{
		mnSortBy.setEnabled(true);
		switch(currentDataSet) {
		case PEOPLECLUSTER:
			try {
				if (pc == null)
					pc = new PeopleClusterDAO();
				/* can try and improve later */
				List<Object> listing = pc.getAllItems();
				PCModel dataModel = new PCModel(listing);
				dataModel.setDAO(pc);
				pcm = dataModel; pcm.setDAO(pc);
				/* sort menu created at runtime */
				createSortMenu(mnSortBy, dataModel);
				resultTable.setModel(dataModel);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			lblStatusLabel.setText("Status: loaded peoplecluster dataset");
			break;
		case COUNTRY:
			try {
				if (c == null)
					c = new CountryDAO();
				/* Open viewing for CountryModel */
				CountryModel dataModel = new CountryModel(c.getAllItems());
				dataModel.setDAO(c); /** 
									  *  setDAO() has 1 unresolved issue 
									  *  <--java.lang.IllegalStateException: SQLite JDBC: inconsistent internal state-->
									  **/
				tcm = dataModel; tcm.setDAO(c);
				/* sort menu created at runtime */
				createSortMenu(mnSortBy, dataModel);
				resultTable.setModel(dataModel);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			lblStatusLabel.setText("Status: loaded country dataset");
			break;
		case RELIGION:
			try {
				if (rel == null)
					rel = new ReligionDAO();
				/* Open viewing for ReligionModel */
				RelModel dataModel = new RelModel(rel.getAllItems());
				dataModel.setDAO(rel);
				relm = dataModel; relm.setDAO(rel);
				/* SortMenu created at runtime */
				createSortMenu(mnSortBy, dataModel);
				resultTable.setModel(dataModel);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			lblStatusLabel.setText("Status: loaded religion dataset");
			break;
		case REGION:
			try {
				if (reg == null)
					reg = new RegionDAO();
				/* Open viewing for RegionModel */
				RegModel dataModel = new RegModel(reg.getAllItems());
				dataModel.setDAO(reg);
				regm = dataModel; regm.setDAO(reg);
				/* SortMenu created at runtime */
				createSortMenu(mnSortBy, dataModel);
				resultTable.setModel(dataModel);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			lblStatusLabel.setText("Status: loaded region dataset");
			break;
		case CONTINENT:
			try {
				if (con == null)
					con = new ContinentDAO();
				/* Open viewing for ContinentModel */
				ConModel dataModel = new ConModel(con.getAllItems());
				dataModel.setDAO(con);
				cm = dataModel; cm.setDAO(con);
				/* SortMenu created at runtime */
				createSortMenu(mnSortBy, dataModel);
				resultTable.setModel(dataModel);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			lblStatusLabel.setText("Status: loaded continent dataset");
			break;
		case AFFINITY:
			try {
				if (aff == null)
					aff = new AffinityDAO();
				/* Open viewing for AffinityModel */
				AffModel dataModel = new AffModel(aff.getAllItems());
				dataModel.setDAO(aff);
				afm = dataModel; afm.setDAO(aff);
				/* SortMenu created at runtime */
				createSortMenu(mnSortBy, dataModel);
				resultTable.setModel(dataModel);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			lblStatusLabel.setText("Status: loaded affinity dataset");
			break;
		}
	}

	/* auxiliary methods for search */
	
	private GlobalDAO getDAO(int currentDataSet)
	{
		switch(currentDataSet){
		case PEOPLECLUSTER:
			return pc;
		case COUNTRY:
			return c;
		case RELIGION:
			return rel;
		case REGION:
			return reg;
		case CONTINENT:
			return con;
		case AFFINITY:
			return aff;
		default:
			return pc;
		}
	}
	
	private AbstractTableModel getModel(int currentDataSet, List<Object> ls)
	{
		switch(currentDataSet){
		case PEOPLECLUSTER:
			return new PCModel(ls);
		case COUNTRY:
			return new CountryModel(ls);
		case RELIGION:
			return new RelModel(ls);
		case REGION:
			return new RegModel(ls);
		case CONTINENT:
			return new ConModel(ls);
		case AFFINITY:
			return new AffModel(ls);
		default:
			return new PCModel(ls);
		}
	}

	private Object getModelType(AbstractTableModel atm)
	{
		switch(currentDataSet) {
		case PEOPLECLUSTER:
			return (PCModel) atm;
		case COUNTRY:
			return (CountryModel) atm;
		case RELIGION:
			return (RelModel) atm;
		case REGION:
			return (RegModel) atm;
		case CONTINENT:
			return (ConModel) atm;
		case AFFINITY:
			return (AffModel) atm;
		default:
			return atm;
		}
	}
}
