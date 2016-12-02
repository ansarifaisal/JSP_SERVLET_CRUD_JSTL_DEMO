package com.niit.crud.student.dao;

import java.util.List;

import com.niit.crud.student.entity.Student;

public interface StudentDAO {
	
	//getting all the Students
	List<Student> students();
	//get id
	Student getId(int studentId);
	//for delete
	boolean deleteStudent(int studentId);
	//for adding
	boolean addStudent(Student student);
	//for updating
	boolean updateStudent(Student student);
	
	
}
