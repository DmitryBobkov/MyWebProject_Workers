package by.academy.worker.entities;

/**
 * Class Manager describes the entity manager
 * 
 */

public class Manager extends Worker implements Cloneable {

	private int position;
	private int gathering;

	private final static double INDEX = 1.2;

	public Manager(int id, String type, String name, Address address, int position, int gathering) {
		super(id, type, name, address);
		this.position = position;
		this.gathering = gathering;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getGathering() {
		return gathering;
	}

	public void setGathering(int gathering) {
		this.gathering = gathering;
	}

	@Override
	public String toString() {
		return "Manager [id= " + getId() + ", name= " + getName() + ", address= " + getAddress().getCity() + ", "
				+ getAddress().getCountry() + ", position= " + position + ", gathering= " + gathering + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + gathering;
		result = prime * result + position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (gathering != other.gathering)
			return false;
		if (position != other.position)
			return false;
		return true;
	}

	@Override
	public Manager clone() throws CloneNotSupportedException {
		Manager managerClone = (Manager) super.clone();
		managerClone.setAddress(super.getAddress().clone());
		return managerClone;
	}

	@Override
	public double pension() {
		return getPension() * INDEX;
	}

}
