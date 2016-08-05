package joshuaproject.implementations;

public class Religion {
	private int rlg;
	private String religion;
	private double population;
	private int cntpeopctry;
	private int cntunreach;
	private double pctunreach;
	private double popunreach;
	private double pctpopunreach;
	
	public Religion(int rlg, String religion, double population, int cntpeopctry, int cntunreach,
			double pctunreach, double popunreach, double pctpopunreach)
	{
		this.setRlg(rlg);
		this.setReligion(religion);
		this.setPopulation(population);
		this.setCntpeopctry(cntpeopctry);
		this.setCntunreach(cntunreach);
		this.setPctunreach(pctunreach);
		this.setPopunreach(popunreach);
		this.setPctpopunreach(pctpopunreach);
	}
	
	public void print() {
		// TODO Auto-generated method stub
		
	}

	public int getRlg() {
		return rlg;
	}

	public void setRlg(int rlg) {
		this.rlg = rlg;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public int getCntpeopctry() {
		return cntpeopctry;
	}

	public void setCntpeopctry(int cntpeopctry) {
		this.cntpeopctry = cntpeopctry;
	}

	public int getCntunreach() {
		return cntunreach;
	}

	public void setCntunreach(int cntunreach) {
		this.cntunreach = cntunreach;
	}

	public double getPctunreach() {
		return pctunreach;
	}

	public void setPctunreach(double pctunreach) {
		this.pctunreach = pctunreach;
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

	
}
