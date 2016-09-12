package org.egen.io.movieFlix.service;

import java.util.List;

import org.egen.io.movieFlix.entity.MediaList;
import org.egen.io.movieFlix.entity.UserReviews;
import org.egen.io.movieFlix.exception.EntityAlreadyExistException;
import org.egen.io.movieFlix.exception.EntityNotFoundException;
import org.egen.io.movieFlix.repository.MediaListRepository;
import org.egen.io.movieFlix.repository.UserReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MediaListServiceImp implements MediaListService{
	
	@Autowired
	private MediaListRepository repository;
	@Autowired
	private UserReviewsRepository  reviewRepo;
	
	@Override
	public List<MediaList> findAll() {
		List<MediaList> mdl = repository.findAll();
		List<Object[]> avr= reviewRepo.findAvgMovieReviews();
		
		for(Object[] av:avr){
			
			for(MediaList md : mdl){
				if(md.getImdbid().matches(av[0].toString())){
					
					md.setUserAvgRating(Double.parseDouble(av[1].toString()));
					break; 
				}
			}
		}
		
		return mdl;
	}

	@Override
	public MediaList findOne(String id) {
		MediaList mdl = repository.findOne(id);
		if(mdl == null){
			throw new EntityNotFoundException("Video Not Found");
		}
		
		return mdl;
	}

	@Override
	@Transactional
	public MediaList create(MediaList mdl) {
		MediaList mdlExist = repository.findOne(mdl.getImdbid());
		if (mdlExist != null) {
			throw new EntityAlreadyExistException("Video already exists with this email");
		}
		return repository.create(mdl);
	}

	@Override
	@Transactional
	public MediaList update(String id, MediaList mdl) {
		MediaList mdlExist = repository.findOne(id);
		if(mdlExist == null  ){
			throw new EntityNotFoundException("Video Not Found");
		}
		return repository.update(mdl);
	}

	@Override
	@Transactional
	public void delete(String imdbid) {
		MediaList mdlExist = repository.findOne(imdbid);
		if (mdlExist == null) {
			throw new EntityNotFoundException("Video not found");
		}
		List<UserReviews> urw = reviewRepo.findMovieReviews(imdbid);
		for(UserReviews ur : urw){
			reviewRepo.delete(ur);
		}
		repository.delete(mdlExist);
		
	}

}
