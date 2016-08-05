package joshuaproject.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import joshuaproject.implementations.*;
import joshuaproject.tablemodel.*;

	/**
	 * 
	 * @author heng
	 * 
	 */
public class CSVFile {
	private static final String COMMA = ",";
	private static final String NEWLINE ="\n";
	private static FileWriter fileWriter = null;

	public static void writeToCSV (PCModel model, String filename) {
		try {
			fileWriter = getFileWriter(filename);

			fileWriter.append(model.getHeader());
				fileWriter.append(NEWLINE.toString());
			List<Object> ls = model.getDAO().getList();
			
			for (Object o : ls) {
				PeopleCluster con = (PeopleCluster) o;
				fileWriter.append(String.valueOf(con.getId()));
					fileWriter.append(COMMA);
				fileWriter.append(con.getName());
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getProgressScale()));
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPercentChristian())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPercentEvangelical())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPrimaryReligion())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPopulation())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPeoples())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPeoplesUnreached())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPercentPeoplesUnreached())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPopUnreached())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPercentPopUnreached()));
					fileWriter.append(NEWLINE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void writeToCSV (CountryModel model, String filename) {
		
	}
	
	public static void writeToCSV (ConModel model, String filename) {
		try {
			fileWriter = getFileWriter(filename);

			fileWriter.append(model.getHeader());
				fileWriter.append(NEWLINE.toString());
			List<Object> ls = model.getDAO().getList();
			
			for (Object o : ls) {
				Continent con = (Continent) o;
				fileWriter.append(con.getId());
					fileWriter.append(COMMA);
				fileWriter.append(con.getContinent());
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getTotalcountries()));
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPopulation())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPeoples())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getUnreachedpeoples())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPctunreachedpeoples())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPopulationunreached())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPctpopulationunreached())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getTenforty())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPctchristian())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPctevangelical())); 
					fileWriter.append(COMMA);
				fileWriter.append(String.valueOf(con.getPcturban()));
					fileWriter.append(NEWLINE);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void writeToCSV (RelModel model, String filename) {
		
	}
	
	public static void writeToCSV (RegModel model, String filename) {
		
	}
	
	public static void writeToCSV (AffModel model, String filename) {
		
	}
	
	public static FileWriter getFileWriter(String filename) throws Exception
	{
		if (fileWriter == null)
		{
			fileWriter = new FileWriter(filename);
		}// else if (!filename.equals(fileWriter.toString()))
		{
			//fileWriter = new FileWriter(filename);
		}
		return fileWriter;
	}
}
