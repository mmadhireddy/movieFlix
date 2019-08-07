package org.egen.io.movieFlix.service;

import java.util.List;

import org.egen.io.movieFlix.entity.User;
import org.egen.io.movieFlix.entity.UserReviews;
import org.egen.io.movieFlix.exception.EntityAlreadyExistException;
import org.egen.io.movieFlix.exception.EntityNotFoundException;
import org.egen.io.movieFlix.repository.UserRepository;
import org.egen.io.movieFlix.repository.UserReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository repository;
	@Autowired
	private UserReviewsRepository  reviewRepo;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User usr = repository.findOne(id);
		if(usr == null){
			throw new EntityNotFoundException("User Not Found");
		}
		
		return usr;
	}

	@Override
	@Transactional
	public User create(User usr) {
		User usrExist = repository.findByEmail(usr.getEmail());
		if (usrExist != null) {
			throw new EntityAlreadyExistException("User already exists with this email");
		}
		else if(validate(usr)){
			throw new EntityAlreadyExistException("Invalid Details");
		}
		return repository.create(usr);
	}

	@Override
	@Transactional
	public User update(String id, User usr) {
		User usrExist = repository.findOne(id);
		
		if(usrExist == null){
			throw new EntityNotFoundException("User Not Found");
		}
		else if(validate(usr)){
			throw new EntityAlreadyExistException("Invalid Details");
		}
		else if(validate(usr)){
			throw new EntityAlreadyExistException("Invalid Details");
		}
		return repository.update(usr);
				
	}

	@Override
	@Transactional
	public void delete(String id) {
		User usrExist = repository.findOne(id);
		if (usrExist == null) {
			throw new EntityNotFoundException("User not found");
		}
		List<UserReviews> urw = reviewRepo.findUserReviews(id);
		for(UserReviews ur : urw){
			reviewRepo.delete(ur);
		}
		repository.delete(id);
	}

	@Override
	public User login(String action,User usr) {
		if(!action.contains("login")){
			
		}
		User usrExist = repository.findByEmail(usr.getEmail());
		if (usrExist == null) {
			throw new EntityAlreadyExistException("User not exist ");
		}
		else if(usrExist.getPassword() != usr.getPassword())
		{
			throw new EntityAlreadyExistException("Invalid Password ");
		}
		return usrExist;
	}

	
	
	
	private Boolean validate(User usr){
		String email = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		String password = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		if(!usr.getEmail().matches(email)){
			return false;
		}
		else if(usr.getFirstName().length()==0){
			return false;
		}
		else if(usr.getLastName().length()==0){
			return false;
		}
		else if(usr.getPassword().length()< 6){
			return false;
		}
		else if(((Integer)usr.getPhone()).toString().length()!= 10){
			return false;
		}
		else if(!usr.getPassword().matches(password)){
			return false;
		}
		return true;
	}
}
