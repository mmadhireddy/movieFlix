package org.egen.io.movieFlix.repository;

import java.util.List;

import org.egen.io.movieFlix.entity.User;

public interface UserRepository {

	public List<User> findAll();

	public User findOne(String id);

	public User findByEmail(String email);

	public User update(User usr);

	public User create(User usr);

	public void delete(String id);

}
