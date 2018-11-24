package code.better.com.service;

import javax.ws.rs.container.AsyncResponse;

import code.better.com.pojo.Student;


public interface IStudentService {

	void get(AsyncResponse response, String id);

	void delete(AsyncResponse response, String studentId);

	void add(AsyncResponse response, Student student);

}
