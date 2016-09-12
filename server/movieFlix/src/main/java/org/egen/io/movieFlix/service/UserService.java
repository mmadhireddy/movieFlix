
package org.egen.io.movieFlix.service;

import java.util.List;

import org.egen.io.movieFlix.entity.User;

public interface UserService {

	public List<User> findAll();
	public User findOne(String id);
	public User create(User usr);
	public User update(String id,User usr);
	public void delete(String id);
	public User login(String action,User usr);

}
