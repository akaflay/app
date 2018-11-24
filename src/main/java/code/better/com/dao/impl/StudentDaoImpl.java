package code.better.com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import code.better.com.core.JsonUtils;
import code.better.com.dao.IStudentDao;
import code.better.com.pojo.Student;

@Repository
public class StudentDaoImpl extends BaseDao<Student> implements IStudentDao {

	@Override
	@Transactional
	public JsonNode findStudents(String id) {
		List<Student> students = new ArrayList<>();
		if (StringUtils.isBlank(id))
			students = find(Student.class);
		else {
			Student st = findById(Student.class, id);
			if (st != null)
				students.add(st);
		}
		ArrayNode arrayNode = JsonUtils.createArrayNode();
		students.forEach(student -> arrayNode.add(JsonUtils.toJson(student)));
		return JsonUtils.createObjectNode().set("content", arrayNode);
	}

	@Override
	@Transactional
	public boolean delete(String studentId) {
		this.delete(Student.class, studentId);
		return true;
	}

	@Transactional
	public void addStudent(Student student) {
		add(student);

	}

}
