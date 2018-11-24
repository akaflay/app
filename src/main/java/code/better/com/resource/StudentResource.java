package code.better.com.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import code.better.com.pojo.Student;
import code.better.com.service.IStudentService;

@Component
@Path("/students")
public class StudentResource {
	
	@Autowired
	private IStudentService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void getStudents(@Suspended AsyncResponse response) {
		service.get(response,null);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void getStudent(@Suspended AsyncResponse response,
				@PathParam("id") String studentId) {
		service.get(response,studentId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void add(@Suspended AsyncResponse response,
				@RequestBody Student student) {
	service.add(response,student);
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@Suspended AsyncResponse response,
				@PathParam("id") String studentId) {
		service.delete(response,studentId);
	}

}
