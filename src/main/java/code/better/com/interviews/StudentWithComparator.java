package code.better.com.interviews;

import java.util.Comparator;

/**
 * 
 * This class is used to check how comparator interface works and what are the requirements
 * We need to override compare Method form Comparator<?> Interface.
 *
 */
public class StudentWithComparator {

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

	/**
	 * 
	 * Using the builder pattern for better readability
	 *
	 */
	public static class StudentBuilder {

		StudentWithComparator student = new StudentWithComparator();

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

		public StudentWithComparator build() {
			return this.student;
		}

	}

	public static class StudentComparator implements Comparator<StudentWithComparator> {

		public int compare(StudentWithComparator firstStudent, StudentWithComparator secondStudent) {
			int idDiff = 0;
			int firstNameDiff = 0;
			idDiff = firstStudent.id.compareTo(secondStudent.id);
			if (idDiff == 0) {
				firstNameDiff = firstStudent.firstName.compareTo(secondStudent.firstName);
				if (firstNameDiff == 0)
					return firstStudent.lastName.compareTo(secondStudent.lastName);
				else
					return firstNameDiff;
			} else return idDiff;
		}

	}

	
}
