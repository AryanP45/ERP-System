package com.aryanp45.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryanp45.studentservice.model.Student;
import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	Optional<Student> findByPrn(Long prn);
}
