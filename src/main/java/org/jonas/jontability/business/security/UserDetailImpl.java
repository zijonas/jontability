package org.jonas.jontability.business.security;

import org.jonas.jontability.persistence.entities.UserDataEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailImpl implements UserDetails {
	private final String username;
	private final String password;
	private final boolean enabled;
	private final List<GrantedAuthority> authorities = new ArrayList<>();

	public UserDetailImpl(UserDataEntity userData) {
		this.username = userData.getUsername();
		this.password = userData.getPassword();
		this.enabled = userData.isEnabled();
		authorities.addAll(userData.getAuthority().stream().map(i -> (GrantedAuthority) i::getRole).collect(Collectors.toList()));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
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
		return enabled;
	}
}
