package joshuaproject.implementations;

public class Region {
	private int code;
	private String name;
	private int cntctry;
	private double population;
	private int cntpeopctry;
	private int cntunreach;
	private double pctunreach;
	private double popunreach;
	private double pctpopunreach;
	private double pcturban;

	public Region(int code, String name, int cntctry, double population, int cntpeopctry,
			int cntunreach, double pctunreach, double popunreach, double pctpopunreach, double pcturban)
	{
		this.setCode(code);
		this.setName(name);
		this.setCntctry(cntctry);
		this.setPopulation(population);
		this.setCntpeopctry(cntpeopctry);
		this.setCntunreach(cntunreach);
		this.setPctunreach(pctunreach);
		this.setPopunreach(popunreach);
		this.setPctpopunreach(pctpopunreach);
		this.setPcturban(pcturban);
	}

	public void print()
	{
		/* <--- implement here ---> */
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCntctry() {
		return cntctry;
	}

	public void setCntctry(int cntctry) {
		this.cntctry = cntctry;
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

	public double getPcturban() {
		return pcturban;
	}

	public void setPcturban(double pcturban) {
		this.pcturban = pcturban;
	}


}
