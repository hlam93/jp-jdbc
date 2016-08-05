package joshuaproject.implementations;

public class Continent {
	private String id;
	private String continent;
	private int totalcountries;
	private double population;
	private int peoples;
	private int unreachedpeoples;
	private double pctunreachedpeoples;
	private double populationunreached;
	private double pctpopulationunreached;
	private int tenforty;
	private double pctchristian;
	private double pctevangelical;
	private double pcturbanized;
	
	public Continent(String id, String continent, int totalcountries, double population, int peoples,
					 int unreachedpeoples, double pctunreachedpeoples, double populationunreached,
					 double pctpopulationunreached, int tenforty, double pctchristian, double pctevangelical,
					 double pcturbanized)
	{
		this.setId(id);
		this.setContinent(continent);
		this.setTotalcountries(totalcountries);
		this.setPopulation(population);
		this.setPeoples(peoples);
		this.setUnreachedpeoples(unreachedpeoples);
		this.setPctunreachedpeoples(pctunreachedpeoples);
		this.setPopulationunreached(populationunreached);
		this.setPctpopulationunreached(pctpopulationunreached);
		this.setTenforty(tenforty);
		this.setPctchristian(pctchristian);
		this.setPctevangelical(pctevangelical);
		this.setPcturban(pcturbanized);
	}
	
	public void print()
	{
		System.out.printf("%3s %-10s %4d %16d %4d %4d %04.1f %4d %4d %04.1f %04.1f %04.1f", id, continent, totalcountries,
						  population, peoples, unreachedpeoples, pctunreachedpeoples, populationunreached, tenforty,
						  pctchristian, pctevangelical, pcturbanized);
		System.out.println();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public int getTotalcountries() {
		return totalcountries;
	}

	public void setTotalcountries(int totalcountries) {
		this.totalcountries = totalcountries;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public int getPeoples() {
		return peoples;
	}

	public void setPeoples(int peoples) {
		this.peoples = peoples;
	}

	public int getUnreachedpeoples() {
		return unreachedpeoples;
	}

	public void setUnreachedpeoples(int unreachedpeoples) {
		this.unreachedpeoples = unreachedpeoples;
	}

	public double getPctunreachedpeoples() {
		return pctunreachedpeoples;
	}

	public void setPctunreachedpeoples(double pctunreachedpeoples) {
		this.pctunreachedpeoples = pctunreachedpeoples;
	}

	public double getPopulationunreached() {
		return populationunreached;
	}

	public void setPopulationunreached(double populationunreached) {
		this.populationunreached = populationunreached;
	}

	public double getPctpopulationunreached() {
		return pctpopulationunreached;
	}

	public void setPctpopulationunreached(double pctpopulationunreached) {
		this.pctpopulationunreached = pctpopulationunreached;
	}
	
	public int getTenforty() {
		return tenforty;
	}

	public void setTenforty(int tenforty) {
		this.tenforty = tenforty;
	}

	public double getPctchristian() {
		return pctchristian;
	}

	public void setPctchristian(double pctchristian) {
		this.pctchristian = pctchristian;
	}

	public double getPctevangelical() {
		return pctevangelical;
	}

	public void setPctevangelical(double pctevangelical) {
		this.pctevangelical = pctevangelical;
	}

	public double getPcturban() {
		return pcturbanized;
	}

	public void setPcturban(double pcturbanized) {
		this.pcturbanized = pcturbanized;
	}
}
