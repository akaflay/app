package code.better.com.interviews;

import java.util.Comparator;

import code.better.com.pojo.Student;

/**
 * 
 * This class is used to check how comparator interface works and what are the
 * requirements We need to override compare Method form Comparator<?> Interface.
 *
 */
public class StudentWithComparator {
	

	/**
	 * 
	 * Using the builder pattern for better readability
	 *
	 */
	public static class StudentBuilder {

		Student student = new Student();

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

		public Student build() {
			return this.student;
		}

	}

	public static class StudentComparator implements Comparator<Student> {

		public int compare(Student firstStudent, Student secondStudent) {
			int idDiff = 0;
			int firstNameDiff = 0;
			idDiff = firstStudent.getId().compareTo(secondStudent.getId());
			if (idDiff == 0) {
				firstNameDiff = firstStudent.getFirstName().compareTo(secondStudent.getFirstName());
				if (firstNameDiff == 0)
					return firstStudent.getLastName().compareTo(secondStudent.getLastName());
				else
					return firstNameDiff;
			} else return idDiff;
		}

	}

}
