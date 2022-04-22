package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.user.User;
import ru.math.tversu.studentapp.repository.user.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
