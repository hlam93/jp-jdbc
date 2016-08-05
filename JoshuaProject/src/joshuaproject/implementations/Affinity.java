package joshuaproject.implementations;

public class Affinity {
	private int peopleId;
	private String affinity;
	private double population;
	private int countPC;
	private int countPE;
	private int countPCountry;
	private int countLeast;
	private double pctLeast;
	private double sumPopLeast;
	private double pctPopLeast;
	
	public Affinity (int peopleId, String affinity, double population, int countPC,
			int countPCountry, int countPE, int countLeast, double pctLeast, double sumPopLeast, double pctPopLeast)
	{
		this.setPeopleId(peopleId);
		this.setAffinity(affinity);
		this.setPopulation(population);
		this.setCountPC(countPC);
		this.setCountPE(countPE);
		this.setCountPCountry(countPCountry);
		this.setCountLeast(countLeast);
		this.setPctLeast(pctLeast);
		this.setSumPopLeast(sumPopLeast);
		this.setPctPopLeast(pctPopLeast);
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

	public int getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}

	public String getAffinity() {
		return affinity;
	}

	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public int getCountPC() {
		return countPC;
	}

	public void setCountPC(int countPC) {
		this.countPC = countPC;
	}

	public int getCountPCountry() {
		return countPCountry;
	}

	public void setCountPCountry(int countPCountry) {
		this.countPCountry = countPCountry;
	}

	public int getCountLeast() {
		return countLeast;
	}

	public void setCountLeast(int countLeast) {
		this.countLeast = countLeast;
	}

	public double getPctLeast() {
		return pctLeast;
	}

	public void setPctLeast(double pctLeast) {
		this.pctLeast = pctLeast;
	}

	public double getSumPopLeast() {
		return sumPopLeast;
	}

	public void setSumPopLeast(double sumPopLeast) {
		this.sumPopLeast = sumPopLeast;
	}

	public double getPctPopLeast() {
		return pctPopLeast;
	}

	public void setPctPopLeast(double pctPopLeast) {
		this.pctPopLeast = pctPopLeast;
	}

	public int getCountPE() {
		return countPE;
	}

	public void setCountPE(int countPE) {
		this.countPE = countPE;
	}

}
