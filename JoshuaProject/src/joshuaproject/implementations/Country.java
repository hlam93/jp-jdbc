package joshuaproject.implementations;

	/**
	 * Written 30 June 2016 by Heng L. Lam
	 */

public class Country {
	private String rog;
	private String country;
	private int cntpeoples;
	private int cntunreach;
	private double population;
	private double popunreach;
	private double pctpopunreach;
	private double pctpeopleunreach;
	private int securitylvl;
	private String religion;
	private double pctevangelical;
	private String win1040;
	private int pcturban;

	public Country (String rog, String country, int cntpeoples, int cntunreach, double population,
			double popunreach, double pctpopunreach, double pctpeopleunreach, int securitylvl, String religion, double pctevangelical,
			String win1040, int pcturban)
	{
		this.setRog(rog);
		this.setCountry(country);
		this.setCntpeoples(cntpeoples);
		this.setCntunreach(cntunreach);
		this.setPopulation(population);
		this.setPopunreach(popunreach);
		this.setPctpopunreach(pctpopunreach);
		this.setPctpeopleunreach(pctpeopleunreach);
		this.setSecuritylvl(securitylvl);
		this.setReligion(religion);
		this.setPctevangelical(pctevangelical);
		this.setWin1040(win1040);
		this.setPcturban(pcturban);
	}


	/* helpful with debugging */
	
	public void print()
	{
		System.out.printf("%s\n", rog);
	}


	public String getRog() {
		return rog;
	}


	public void setRog(String rog) {
		this.rog = rog;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getCntpeoples() {
		return cntpeoples;
	}


	public void setCntpeoples(int cntpeoples) {
		this.cntpeoples = cntpeoples;
	}


	public int getCntunreach() {
		return cntunreach;
	}


	public void setCntunreach(int cntunreach) {
		this.cntunreach = cntunreach;
	}


	public double getPopulation() {
		return population;
	}


	public void setPopulation(double population) {
		this.population = population;
	}


	public double getPopunreach() {
		return popunreach;
	}


	public void setPopunreach(double popunreach) {
		this.popunreach = popunreach;
	}


	public double getPctpopunreach() {
		return pctpopunreach;
	}


	public void setPctpopunreach(double pctpopunreach) {
		this.pctpopunreach = pctpopunreach;
	}


	public double getPctpeopleunreach() {
		return pctpeopleunreach;
	}


	public void setPctpeopleunreach(double pctpeopleunreach) {
		this.pctpeopleunreach = pctpeopleunreach;
	}


	public int getSecuritylvl() {
		return securitylvl;
	}


	public void setSecuritylvl(int securitylvl) {
		this.securitylvl = securitylvl;
	}


	public String getReligion() {
		return religion;
	}


	public void setReligion(String religion) {
		this.religion = religion;
	}


	public double getPctevangelical() {
		return pctevangelical;
	}


	public void setPctevangelical(double pctevangelical) {
		this.pctevangelical = pctevangelical;
	}


	public String getWin1040() {
		return win1040;
	}


	public void setWin1040(String win1040) {
		this.win1040 = win1040;
	}


	public int getPcturban() {
		return pcturban;
	}


	public void setPcturban(int pcturban) {
		this.pcturban = pcturban;
	}
	
	/* getter and setter methods */
	
	

	
}
