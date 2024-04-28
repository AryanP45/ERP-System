package com.aryanp45.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryanp45.authservice.model.UserCredential;


@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Long>{
	Optional<UserCredential> findByName(String name);
}
