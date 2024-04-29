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

	public String saveUser(UserCredential credential,String role) {
		credential.setPassword(passwordEncoder.encode(credential.getPassword()));
		credential.setRole(role);
		repository.save(credential);
		return "user added to the system";
	}

	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}

	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

}
