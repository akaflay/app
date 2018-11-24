package code.better.com.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import code.better.com.interviews.StudentWithComparator;
import code.better.com.interviews.StudentWithComparator.StudentBuilder;
import code.better.com.pojo.Student;

public class StudentWithComparatorTest {

	@Test
	public void testComparatorWithSameValue() {
		List<Student> studentLists = new ArrayList<>();
		Student student = new StudentBuilder().setId("1").setFirstName("John").setLastName("Sena")
				.build();
		studentLists.add(student);
		student = new StudentBuilder().setId("1").setFirstName("John").setLastName("Sena").build();
		studentLists.add(student);
		Collections.sort(studentLists, new StudentWithComparator.StudentComparator());
		studentLists.forEach(System.out::println);
	}

	@Test
	public void testComparatorWithDifferentValue() {
		List<Student> studentLists = new ArrayList<>();
		Student student = new StudentBuilder().setId("2").setFirstName("John").setLastName("Sena")
				.build();
		studentLists.add(student);
		student = new StudentBuilder().setId("1").setFirstName("John").setLastName("Sena").build();
		studentLists.add(student);
		Collections.sort(studentLists, new StudentWithComparator.StudentComparator());
		studentLists.forEach(System.out::println);
	}

}
