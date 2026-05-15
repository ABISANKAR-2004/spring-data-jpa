package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibm.dto.StudentDTO;
import com.ibm.entity.Student;
import com.ibm.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
@Tag(name = "Student API", description = "CRUD operations related to Student management")
public class StudentController {

	@Autowired
	private StudentService service;

	@Operation(summary = "Fetch all students", description = "Returns a list of all students")
	@ApiResponse(responseCode = "200", description = "Students fetched successfully")
	@GetMapping("/all")
	public ResponseEntity<List<StudentDTO>> getAllStudent() {
		return ResponseEntity.ok(service.getAllStudents());
	}

	@Operation(summary = "Get student by ID", description = "Fetch student details using student ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Student found"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	@GetMapping("/id/{id}")
	public ResponseEntity<StudentDTO> getStudent(
			@Parameter(description = "Student ID", example = "101") @PathVariable Integer id) {

		return ResponseEntity.ok(service.getStudentById(id));
	}

	@Operation(summary = "Update student", description = "Updates an existing student by ID")
	@ApiResponses({ @ApiResponse(responseCode = "202", description = "Student updated successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	@PutMapping("/update/{id}")
	public ResponseEntity<StudentDTO> update(@Parameter(description = "Student ID") @PathVariable Integer id,
			 @RequestBody StudentDTO student) {

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateStudent(id, student));
	}

	@Operation(summary = "Delete student", description = "Removes a student by ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Student deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> remove(@Parameter(description = "Student ID") @PathVariable Integer id) {

		service.removeStudent(id);
		return ResponseEntity.ok("Student Removed Successfully");
	}

	@Operation(summary = "Add a new student", description = "Creates a new student record")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Student created successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid request data") })
	@PostMapping("/add")
	public ResponseEntity<String> add( @RequestBody StudentDTO student) {

		return new ResponseEntity<>(service.addStudent(student), HttpStatus.CREATED);
	}

	// ✅ Get student by name
	@Operation(summary = "Get student by name", description = "Fetch student details using name")
	@ApiResponse(responseCode = "200", description = "Student found")
	@GetMapping("/name/{name}")
	public ResponseEntity<StudentDTO> getByName(@Parameter(description = "Student name") @PathVariable String name) {

		return ResponseEntity.ok(service.getStudentByName(name));
	}

	@Operation(summary = "Get students by marks range", description = "Fetch students whose marks fall between start and end values")
	@Parameters({ @Parameter(name = "start", description = "Minimum marks", example = "60"),
			@Parameter(name = "end", description = "Maximum marks", example = "90") })
	@ApiResponse(responseCode = "200", description = "Students fetched successfully")
	@GetMapping("/marks")
	public ResponseEntity<List<Student>> getStudentsByMarks(@RequestParam Integer start, @RequestParam Integer end) {

		return ResponseEntity.ok(service.getStudentsByMarks(start, end));
	}

	@GetMapping("/ps")
	public ResponseEntity<Page<StudentDTO>> getStudentsUsingPagination(@RequestParam Integer page, @RequestParam Integer size,
			@RequestParam String field, @RequestParam String dir) {
		
		return ResponseEntity.ok(service.getStudentsPaginationAndSort(page,size,field,dir));
	}
	
	@GetMapping("/greeting")
	public String grretingMessage() {
		return "Welcome to spring security";
	}
}