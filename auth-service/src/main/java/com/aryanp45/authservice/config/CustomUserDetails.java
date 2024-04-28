package com.aryanp45.authservice.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aryanp45.authservice.enums.Role;
import com.aryanp45.authservice.model.UserCredential;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
//    private Role role;		// for RBAC
    
    public CustomUserDetails(UserCredential userCredential) {
        this.username = userCredential.getName();
        this.password = userCredential.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}