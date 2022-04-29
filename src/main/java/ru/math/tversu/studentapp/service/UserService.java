package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.user.User;
import ru.math.tversu.studentapp.repository.user.UserRepository;

import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getById(Integer id) {
		return userRepository.findById(id).orElse(new User());
	}

	public User createEntity() {
		Integer lastId = userRepository.findFirstByOrderByIdDesc().getId();
		User user = new User();
		user.setId(++lastId);
		return user;
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}
}
