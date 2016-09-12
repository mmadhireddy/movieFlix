package org.egen.io.movieFlix.service;

import java.util.List;

import org.egen.io.movieFlix.UserReviewsPK;
import org.egen.io.movieFlix.entity.UserReviews;
import org.egen.io.movieFlix.exception.EntityNotFoundException;
import org.egen.io.movieFlix.repository.UserReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserReviewsServiceImp implements UserReviewsService{

	@Autowired
	UserReviewsRepository repository;
	
	@Override
	public List<UserReviews> findAll() {
		return repository.findAll();
	}

	@Override
	public UserReviews findOne(UserReviewsPK urwPK) {
		UserReviews urw = repository.findOne(urwPK);
		if(urw == null){
			throw new EntityNotFoundException("Reviews Not Found");
		}
		
		return urw;
	}

	@Override
	public List<UserReviews> findMovieReviews(String imdbID) {
		List<UserReviews> urw = repository.findMovieReviews(imdbID);
		if(urw == null){
			throw new EntityNotFoundException("Reviews Not Found for Moview");
		}
		
		return urw;
	}

	

	@Override
	@Transactional
	public UserReviews update(UserReviewsPK urw_pk,UserReviews urw) {
		UserReviews urwExist = repository.findOne(urw_pk);
		if(urwExist == null){
			throw new EntityNotFoundException("Review is  Not Found");
		}
		return repository.update(urw);
	}

	@Override
	@Transactional
	public UserReviews create(UserReviews urw) {
		UserReviewsPK urw_pk= new UserReviewsPK();
		urw_pk.setImdbid(urw.getImdbid());
		urw_pk.setUserid(urw.getUserid());
		UserReviews urwExist = repository.findOne(urw_pk);
		if(urwExist == null){
			throw new EntityNotFoundException("Review is  Already Exist");
		}
		return repository.create(urw);
	}

	@Override
	@Transactional
	public void delete(UserReviewsPK urw_pk) {
		UserReviews urwExist = repository.findOne(urw_pk);
		if (urwExist == null) {
			throw new EntityNotFoundException("Review not found");
		}
		repository.delete(urwExist);
	}

	
}
