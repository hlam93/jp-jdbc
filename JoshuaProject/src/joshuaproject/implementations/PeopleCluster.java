package joshuaproject.implementations;

/**
	 * Written 30 June 2016 by Heng L. Lam
	 */

public class PeopleCluster {
	private int id;
	private String peopleCluster;
	private int progressScale;
	private double percentChristian;
	private double percentEvangelical;
	private String primaryReligion;
	private double population;
	private int peoples;
	private int peoplesUnreached;
	private double percentPeoplesUnreached;
	private double popUnreached;
	private double percentPopUnreached;
	
	public PeopleCluster (
			int id, String peopleCluster, int progressScale, double percentChristian,
			double percentEvangelical, String primaryReligion, double population,
			int peoples, int peoplesUnreached, double percentPeoplesUnreached,
			double popUnreached, double percentPopUnreached
			)
	{
		this.setId(id);
		this.setName(peopleCluster);
		this.setProgressScale(progressScale);
		this.setPercentChristian(percentChristian);
		this.setPercentEvangelical(percentEvangelical);
		this.setPrimaryReligion(primaryReligion);
		this.setPopulation(population);
		this.setPeoples(peoples);
		this.setPeoplesUnreached(peoplesUnreached);
		this.setPercentPeoplesUnreached(percentPeoplesUnreached);
		this.setPopUnreached(popUnreached);
		this.setPercentPopUnreached(percentPopUnreached);
	}
	
	/* helpful with debugging */
	public void print()
	{
//		System.out.printf("%s %-35s %4d %04.2f %04.2f %18s %12d %4d %4d %04.1f %d %02.1f", idPeopleCluster, peopleCluster, progressScale, percentChristian, percentEvangelical,
//						primaryReligion, population, peoples, peoplesUnreached, percentPeoplesUnreached, popUnreached, percentPopUnreached);
		System.out.printf("%3s %-35s %4s %6s %6s %18s %12s %4s %4s %6s %s %3s", id, peopleCluster, progressScale, percentChristian, percentEvangelical,
						primaryReligion, population, peoples, peoplesUnreached, percentPeoplesUnreached, popUnreached, percentPopUnreached);
		System.out.println();
	}
	
	/* getter and setter methods */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return peopleCluster;
	}

	public void setName(String peopleCluster) {
		this.peopleCluster = peopleCluster;
	}

	public double getPercentChristian() {
		return percentChristian;
	}

	public void setPercentChristian(double percentChristian) {
		this.percentChristian = percentChristian;
	}

	public double getPercentEvangelical() {
		return percentEvangelical;
	}

	public void setPercentEvangelical(double percentEvangelical) {
		this.percentEvangelical = percentEvangelical;
	}

	public String getPrimaryReligion() {
		return primaryReligion;
	}

	public void setPrimaryReligion(String primaryReligion) {
		this.primaryReligion = primaryReligion;
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

	public int getPeoplesUnreached() {
		return peoplesUnreached;
	}

	public void setPeoplesUnreached(int peoplesUnreached) {
		this.peoplesUnreached = peoplesUnreached;
	}

	public double getPercentPeoplesUnreached() {
		return percentPeoplesUnreached;
	}

	public void setPercentPeoplesUnreached(double percentPeoplesUnreached) {
		this.percentPeoplesUnreached = percentPeoplesUnreached;
	}

	public double getPopUnreached() {
		return popUnreached;
	}

	public void setPopUnreached(double popUnreached) {
		this.popUnreached = popUnreached;
	}

	public double getPercentPopUnreached() {
		return percentPopUnreached;
	}

	public void setPercentPopUnreached(double percentPopUnreached) {
		this.percentPopUnreached = percentPopUnreached;
	}

	public int getProgressScale() {
		return progressScale;
	}

	public void setProgressScale(int progressScale) {
		this.progressScale = progressScale;
		
	}
}
