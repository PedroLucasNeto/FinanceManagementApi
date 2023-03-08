package com.financemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.financemanagement.model.User;
import com.financemanagement.repository.UserRepository;

@Service
public class UserService {
	
	
	private final PasswordEncoder passwordEncoder;
	
	public UserService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Autowired
	UserRepository userRepository;

	public boolean createUser(User user) {

		if (user != null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return true;
		}
		return false;
	}

	public void deleteUser(Long id) throws Exception {
		User deleteUser = userRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find an User with this ID: " + id));
		userRepository.delete(deleteUser);
	}

	public User updateUser(Long id, User user) throws Exception {
		User updatedUser = userRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find an User with this ID: " + id));
		updatedUser.setName(user.getName());
		updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(updatedUser);
		return updatedUser;

	}

	public Iterable<User> listUsers() {
		Iterable<User> listUsers = userRepository.findAll();
		return listUsers;
	}

	public Iterable<User> findByName(String name) {
		Iterable<User> users = userRepository.findByName(name);
		return users;
	}

	public User findById(Long id) throws Exception {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find an User with this ID: " + id));
		return user;
	}

	public Boolean findByEmail(String email, String password) {
		boolean authenticated = false;
		User user = userRepository.findByEmail(email);
		if (user!=null) {
			authenticated = passwordEncoder.matches(password, user.getPassword());
			return authenticated;
		}
		return authenticated;
	}

}
