package by.academy.worker.entities;

/**
 * Class Researcher describes the entity researcher
 * 
 */

public class Scientist extends Worker implements Cloneable {

	private int publications;

	private final static double INDEX = 1.3;

	public Scientist(int id, String type, String name, Address address, int publications) {
		super(id, type, name, address);
		this.publications = publications;
	}

	public int getPublications() {
		return publications;
	}

	public void setPublications(int publications) {
		this.publications = publications;
	}

	@Override
	public String toString() {
		return "Scientist [id= " + getId() + ", name= " + getName() + ", address= " + getAddress().getCity() + ", "
				+ getAddress().getCountry() + " publications= " + publications + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + publications;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (getAddress().getCountry() == null) {
			if (other.getAddress().getCountry() != null)
				return false;
		} else if (!getAddress().getCountry().equals(other.getAddress().getCountry())) {
			return false;
		}
		return true;
	}

	public Scientist clone() throws CloneNotSupportedException {
		Scientist researcherClone = (Scientist) super.clone();
		researcherClone.setAddress(this.getAddress().clone());
		return researcherClone;
	}

	@Override
	public double pension() {
		return getPension() * INDEX;
	}

}
