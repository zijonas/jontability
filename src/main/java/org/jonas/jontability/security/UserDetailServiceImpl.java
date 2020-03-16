package org.jonas.jontability.security;

import org.jonas.jontability.entities.UserDataEntity;
import org.jonas.jontability.persistence.UserDataRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserDataRepository userDataRepository;

	public UserDetailServiceImpl(UserDataRepository userDataRepository) {
		this.userDataRepository = userDataRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDataEntity> user = userDataRepository.findById(username);

		user.orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));

		return 	user.map(UserDetailImpl::new).get();
	}
}
