package main.java.com.namesorter.model;

/**
 * Model class for {@code Name} Name.
 * 
 * @author Dilani Alvis
 *
 */
public class Name {

	private String lastName;
	private String givenName;

	public Name() {
	}

	public Name(String lastName, String givenName) {
		this.lastName = lastName;
		this.givenName = givenName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public boolean equals(Object obj) {
		Name name = obj != null && obj instanceof Name ? (Name) obj : null;
		boolean status = false;
		if (name != null && this.lastName.equalsIgnoreCase(name.getLastName())
				&& this.givenName.equalsIgnoreCase(name.getGivenName())) {
			status = true;
		}
		return status;
	}

	@Override
	public String toString() {
		return givenName + " " + lastName;
	}

}
