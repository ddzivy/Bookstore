package com.example.Bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Person, Long> {
	Person findByUsername(String username);
	List<Person> findByEmail(String email);
}