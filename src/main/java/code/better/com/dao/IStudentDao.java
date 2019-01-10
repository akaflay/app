package code.better.com.dao;


import java.util.List;


import code.better.com.pojo.Student;


public interface IStudentDao {
	List<Student> findStudents(String id);

	boolean delete(String studentId);

}
