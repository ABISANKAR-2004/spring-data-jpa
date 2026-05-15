package com.ibm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ibm.dto.StudentDTO;
import com.ibm.entity.Student;
import com.ibm.exception.ResourceNotFoundException;
import com.ibm.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	List<Student> list = new ArrayList<Student>();

	/*
	 * public List<Student> getAllStudents() { return (List<Student>)
	 * repository.findAll(); }
	 */

	public List<StudentDTO> getAllStudents() {
		List<StudentDTO> dtoList = new ArrayList<>();

		repository.findAll().forEach(student -> {
			dtoList.add(new StudentDTO(student.getId(),student.getName(), student.getMarks()));
		});
		return dtoList;

	}

	public StudentDTO getStudentById(Integer id) {
		Student student = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));

		return mapToDto(student);
	}

	private StudentDTO mapToDto(Student student) {
		return new StudentDTO(student.getId(), student.getName(), student.getMarks());
	}

	public StudentDTO updateStudent(Integer id, StudentDTO s1) {
		Student student = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
		student.setName(s1.getName());
		student.setMarks(s1.getMarks());
		repository.save(student);
		return mapToDto(student);
	}

	public void removeStudent(Integer id) {

		Student student = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));

		repository.delete(student);
	}

	public String addStudent(StudentDTO s1) {
		Student student = new Student();
		student.setMarks(s1.getMarks());
		student.setName(s1.getName());
		repository.save(student);
		return "Student Added Suucessfully";
	}

	public StudentDTO getStudentByName(String name) {
		// TODO Auto-generated method stub
		Student student = repository.findByName(name).orElseThrow(()-> new ResourceNotFoundException("Invalid Name") );
		
		return mapToDto(student);

	}

	public List<Student> getStudentsByMarks(Integer sm, Integer em) {
		return repository.findByMarksBetween(sm, em);
	}

	public Page<StudentDTO> getStudentsPaginationAndSort(Integer page, Integer size, String field, String dir) {

		 Sort sort = dir.equalsIgnoreCase("desc")
		            ? Sort.by(field).descending()
		            : Sort.by(field).ascending();

		    Pageable pageable = PageRequest.of(page, size, sort);
		    Page<Student> studentPage= repository.findAll(pageable);
		    

		return studentPage.map(this::mapToDto);
	}

}