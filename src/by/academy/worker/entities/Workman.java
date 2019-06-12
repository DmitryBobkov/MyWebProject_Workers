package by.academy.worker.entities;

/**
 * Class Workman describes the entity workman
 * 
 */

public class Workman extends Worker implements Cloneable {

	private final static double INDEX = 1.4;

	public Workman(int id, String type, String name, Address address) {
		super(id, type, name, address);
	}

	@Override
	public String toString() {
		return "Workman [id= " + getId() + ", name= " + getName() + ", address= " + getAddress().getCity() + ", "
				+ getAddress().getCountry() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getAddress().getCity() == null) ? 0 : getAddress().getCity().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + getId();
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
		if (getAddress().getCity() == null) {
			if (other.getAddress().getCity() != null)
				return false;
		} else if (!getAddress().getCity().equals(other.getAddress().getCity()))
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (getId() != other.getId())
			return false;
		return true;
	}

	@Override
	public Workman clone() throws CloneNotSupportedException {
		Workman workmanClone = (Workman) super.clone();
		workmanClone.setAddress(this.getAddress().clone());
		return workmanClone;
	}

	@Override
	public double pension() {
		return getPension() * INDEX;
	}

}
