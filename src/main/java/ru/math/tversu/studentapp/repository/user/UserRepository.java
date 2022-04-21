package ru.math.tversu.studentapp.repository.user;

import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.user.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findAll();
}
