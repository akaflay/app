package code.better.com.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import code.better.com.interviews.StudentWithComparable;
import code.better.com.interviews.StudentWithComparable.StudentBuilder;


public class StudentWithComparableTest {
	@Test
	public void testComparableWithSameValue() {
		List<StudentWithComparable> studentLists = new ArrayList<>();
		StudentWithComparable student = new StudentBuilder().setId("1").setFirstName("John").setLastName("Sena")
				.build();
		studentLists.add(student);
		student = new StudentBuilder().setId("1").setFirstName("John").setLastName("Sena").build();
		studentLists.add(student);
		Collections.sort(studentLists);
		studentLists.forEach(System.out::println);
	}

	@Test
	public void testComparableWithDifferentValue() {
		List<StudentWithComparable> studentLists = new ArrayList<>();
		StudentWithComparable student = new StudentBuilder().setId("2").setFirstName("John").setLastName("Sena")
				.build();
		studentLists.add(student);
		student = new StudentBuilder().setId("1").setFirstName("John").setLastName("Sena").build();
		studentLists.add(student);
		Collections.sort(studentLists);
		studentLists.forEach(System.out::println);
	}

}
