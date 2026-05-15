package com.ibm.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.repository.CrudRepository;

import com.ibm.entity.Student;

//public interface StudentRepository extends CrudRepository<Student, Integer> {
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Optional<Student> findByName(String name);
	List<Student> findByMarksBetween(Integer sm,Integer em);
	List<Student> findByNameContainingIgnoreCase(String key);

}
