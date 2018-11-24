package code.better.com.dao;


import com.fasterxml.jackson.databind.JsonNode;


public interface IStudentDao {
	JsonNode findStudents(String id);

	boolean delete(String studentId);

}
