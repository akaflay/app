package code.better.com.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import javax.ws.rs.container.AsyncResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import code.better.com.core.JsonUtils;
import code.better.com.dao.impl.StudentDaoImpl;
import code.better.com.pojo.Student;
import code.better.com.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentDaoImpl dao;

	@Override
	public void get(AsyncResponse response, String id) {
		getStudents(id).thenApply(response::resume).exceptionally(response::resume);

	}

	public CompletableFuture<List<Student>> getStudents(String id) {
		return CompletableFuture.completedFuture(dao.findStudents(id));
	}

	@Override
	public void delete(AsyncResponse response, String studentId) {
		delete(studentId).thenApply(response::resume).exceptionally(response::resume);

	}

	private CompletableFuture<JsonNode> delete(String studentId) {
		ObjectNode response = JsonUtils.createObjectNode();
		if (dao.delete(studentId))
			response.put("response",  studentId);
		else
			response.put("response", "Unable to deleted student with id " + studentId);
		return CompletableFuture.completedFuture(response);
	}

	@Override
	public void add(AsyncResponse response, Student student) {
		add(student).thenApply(response::resume).exceptionally(response::resume);
	}

	private CompletableFuture<JsonNode> add(Student student) {
		ObjectNode response = JsonUtils.createObjectNode();
		student.setId(UUID.randomUUID().toString());
		dao.addStudent(student);
		response.put("response", student.getId());
		return CompletableFuture.completedFuture(response);
	}

}
