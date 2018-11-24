package code.better.com.interviews;


/**
 * 
 * This class is used to check how comparable interface works and what are the requirements
 * We need to override compareTo Method form Comparable<?> Interface.
 * We also need to override the equals method and hasCode Method.
 * Note the Equals method and the HashCode method is also required if you want to
 * use this object as the key for the map
 *
 */
public class StudentWithComparable implements Comparable<StudentWithComparable> {

	private String id;
	private String firstName;
	private String lastName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof StudentWithComparable) {
			StudentWithComparable student = (StudentWithComparable) object;
			return this.id.equals(student.getId()) && this.firstName.equals(student.getFirstName())
					&& this.lastName.equals(student.lastName);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode() + firstName.hashCode() + lastName.hashCode();
	}

	/**
	 * 
	 * Using the builder pattern for better readability
	 *
	 */
	public static class StudentBuilder {

		StudentWithComparable student = new StudentWithComparable();

		public StudentBuilder setId(String id) {
			this.student.setId(id);
			return this;
		}

		public StudentBuilder setFirstName(String firstName) {
			this.student.setFirstName(firstName);
			return this;
		}

		public StudentBuilder setLastName(String lastName) {
			this.student.setLastName(lastName);
			return this;
		}

		public StudentWithComparable build() {
			return this.student;
		}

	}

	@Override
	public int compareTo(StudentWithComparable student) {
		int idDiff = 0;
		int firstNameDiff = 0;
		idDiff = this.id.hashCode() - student.getId().hashCode();
		if (idDiff == 0) {
			firstNameDiff = this.firstName.hashCode() - student.firstName.hashCode();
			if (firstNameDiff == 0)
				return this.lastName.hashCode() - student.lastName.hashCode();
			else
				return firstNameDiff;
		}else return idDiff;

	}

	
}
