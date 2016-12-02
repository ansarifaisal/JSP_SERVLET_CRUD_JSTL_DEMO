package com.niit.crud.student.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.crud.student.dao.StudentDAO;
import com.niit.crud.student.entity.Student;
import com.niit.crud.student.util.DBUtil;

public class StudentDAOImpl implements StudentDAO{
	//Connection object
	public static Connection connection = null;
	//creating StudentDAO object
	private static StudentDAO studentDAO = null;
	//Singleton pattern
	public static StudentDAO getStudentDAO(){
		if(studentDAO==null){
			studentDAO = new StudentDAOImpl();
		}
		return studentDAO;
	}
	//default constructor
	public StudentDAOImpl() {
		//connection object initialization
		if(connection==null){
			connection = DBUtil.getConnection();
		}
	}
	Student student;
	
	@Override
	public List<Student> students() {
		List<Student> students = new ArrayList<>();
		String selectQuery = "SELECT * FROM student";
		try(PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setRollNumber(resultSet.getInt("roll_no"));
				student.setYear(resultSet.getInt("year"));
				student.setFirstName(resultSet.getString("first_name"));
				student.setLastName(resultSet.getString("last_name"));
				student.setAddress(resultSet.getString("address"));
				students.add(student);
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
			return null;
		}
		return students;
	}

	@Override
	public Student getId(int studentId) {
		student = new Student();
		String selectQuery = "SELECT * FROM student WHERE id = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
			preparedStatement.setInt(1, studentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				student.setId(resultSet.getInt("id"));
				student.setRollNumber(resultSet.getInt("roll_no"));
				student.setYear(resultSet.getInt("year"));
				student.setFirstName(resultSet.getString("first_name"));
				student.setLastName(resultSet.getString("last_name"));
				student.setAddress(resultSet.getString("address"));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
		}
		return student;
	}

	@Override
	public boolean deleteStudent(int studentId) {
		String deleteQuery = "DELETE FROM student WHERE id = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
			preparedStatement.setInt(1, studentId);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
			return false;
		}
		
	}

	@Override
	public boolean addStudent(Student student) {
		String insertQuery = "INSERT INTO student(roll_no, year, first_name, last_name, address) VALUES "
				+ "(?,?,?,?,?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
			preparedStatement.setInt(1, student.getRollNumber());
			preparedStatement.setInt(2, student.getYear());
			preparedStatement.setString(3, student.getFirstName());
			preparedStatement.setString(4, student.getLastName());
			preparedStatement.setString(5, student.getAddress());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
			return false;
		}
		
	}

	@Override
	public boolean updateStudent(Student student) {
		String updateQuery = "UPDATE student SET "
				+ "roll_no=?, year=?, first_name=?, last_name=?, address=? "
				+ "WHERE id = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			preparedStatement.setInt(1, student.getRollNumber());
			preparedStatement.setInt(2, student.getYear());
			preparedStatement.setString(3, student.getFirstName());
			preparedStatement.setString(4, student.getLastName());
			preparedStatement.setString(5, student.getAddress());
			preparedStatement.setInt(6, student.getId());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
			return false;
		}
	}

}
