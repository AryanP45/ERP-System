package com.aryanp45.authservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aryanp45.authservice.model.UserCredential;
import com.aryanp45.authservice.repository.UserCredentialRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final UserCredentialRepository repository;
	private  final PasswordEncoder passwordEncoder;
	private  final JwtService jwtService;

	public String saveUser(UserCredential credential) {
		credential.setPassword(passwordEncoder.encode(credential.getPassword()));
		repository.save(credential);
		return "user added to the system";
	}


}
