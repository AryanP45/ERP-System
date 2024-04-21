package com.aryanp45.facultyservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryanp45.facultyservice.model.Faculty;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	Optional<Faculty> findByFacultyId(Long facultyId);
}
