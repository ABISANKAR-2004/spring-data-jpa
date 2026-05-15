/*
 * package com.ibm.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.ibm.dto.StudentDTO; import com.ibm.entity.Student; import
 * com.ibm.service.StudentService;
 * 
 * import io.swagger.v3.oas.annotations.Operation; import
 * io.swagger.v3.oas.annotations.responses.ApiResponse; import
 * io.swagger.v3.oas.annotations.responses.ApiResponses; import
 * io.swagger.v3.oas.annotations.tags.Tag; import jakarta.validation.Valid;
 * 
 * @RestController
 * 
 * @RequestMapping("/student")
 * 
 * @Tag(name = "Student API", description =
 * "Operations related to Student management") public class StudentController {
 * 
 * @Autowired private StudentService service;
 * 
 * @GetMapping("/all")
 * 
 * 
 * public ResponseEntity<List<StudentDTO>> getAllStudent() { return
 * ResponseEntity.ok(service.getAllStudents()); }
 * 
 * // Old Implementation
 * 
 * 
 * @GetMapping("/{id}") public ResponseEntity<Student>
 * getStudent(@PathVariable("id") Integer id) { Optional<Student> student =
 * service.getStudentById(id);
 * 
 * if (student.isPresent()) {
 * 
 * return ResponseEntity.status(HttpStatus.OK).header("custom-header",
 * "student").body(student.get()); // 200 OK return
 * ResponseEntity.ok(student.get()); } else { return
 * ResponseEntity.notFound().build(); // 404 Not Found } }
 * 
 * //-----------------------------------------
 * 
 * @GetMapping("/{id}") public ResponseEntity<StudentDTO>
 * getStudent(@PathVariable("id") Integer id) { return
 * ResponseEntity.ok(service.getStudentById(id)); }
 * 
 * @PutMapping("/update/{id}") public ResponseEntity<StudentDTO>
 * update(@Valid @PathVariable("id") Integer id, @RequestBody StudentDTO
 * student) { return
 * ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateStudent(id,
 * student));
 * 
 * 
 * }
 * 
 * 
 * @DeleteMapping("/remove/{id}") public ResponseEntity<String>
 * remove(@PathVariable("id") Integer id) { if (service.removeStudent(id))
 * return ResponseEntity.ok("Student Removed Successfully"); else return
 * ResponseEntity.status(HttpStatus.NOT_FOUND).
 * body("Student Not found this id : " + id); }
 * 
 * 
 * @DeleteMapping("/remove/{id}") public ResponseEntity<String>
 * remove(@PathVariable Integer id) { service.removeStudent(id); return
 * ResponseEntity.ok("Student Removed Successfully"); }
 * 
 * @PostMapping("/add")
 * 
 * @Operation(summary = "Add a new Student")
 * 
 * @ApiResponses({
 * 
 * @ApiResponse(responseCode = "201", description =
 * "Students created successfully"),
 * 
 * @ApiResponse(responseCode = "400", description = "Invalid request") }) public
 * ResponseEntity<String> add(@Valid @RequestBody StudentDTO student) { if
 * (student.getName() != null && student.getMarks() != null) return new
 * ResponseEntity<String>(service.addStudent(student), HttpStatus.CREATED);
 * 
 * return
 * ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter the All fields"); }
 * 
 * @GetMapping("/name/{name}") public ResponseEntity<StudentDTO>
 * getByName(@PathVariable("name") String name) {
 * 
 * return ResponseEntity.ok(service.getStudentByName(name));
 * 
 * }
 * 
 * @GetMapping("/marks") public ResponseEntity<List<Student>>
 * getStudentsByMarks(@RequestParam Integer start, @RequestParam Integer end) {
 * 
 * return ResponseEntity.ok(service.getStudentsByMarks(start, end)); }
 * 
 * } I want all documentation annotations without schema  //tudent
 */
