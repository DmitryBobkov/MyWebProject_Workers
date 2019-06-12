package by.academy.worker.entities;

/**
 * Class Worker describes the entity worker
 * 
 */

public class Worker implements Cloneable {

	private int id;
	private String type;
	private String name;
	private Address address;

	private final static double INDEX = 1.1;
	private static int pension = 500;

	public Worker(int id, String type, String name, Address address) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static double getPension() {
		return pension;
	}

	public static void setPension(int pension) {
		Worker.pension = pension;
	}

	@Override
	public String toString() {
		return "Worker [id= " + id + ", name= " + name + ", address= " + address.getCity() + ", " + address.getCountry()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + id;
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public Worker clone() throws CloneNotSupportedException {
		Worker workerClone = (Worker) super.clone();
		workerClone.address = this.address.clone();
		return workerClone;
	}

	public double pension() {
		return pension * INDEX;
	}

}
