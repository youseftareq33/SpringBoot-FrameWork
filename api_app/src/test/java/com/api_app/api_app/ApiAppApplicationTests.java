package com.api_app.api_app;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api_app.api_app.model.Student;
import com.api_app.api_app.repository.StudentRepository;

@SpringBootTest
class ApiAppApplicationTests {
	@Autowired
	StudentRepository stud_repo;

	@Test
	public void testSaveStudent(){

		Student stud=new Student(1,"yousef",88.2);
		stud_repo.save(stud);

		Student savedStudent=stud_repo.findById(1).get();
		assertNotNull(savedStudent);
	}

}
