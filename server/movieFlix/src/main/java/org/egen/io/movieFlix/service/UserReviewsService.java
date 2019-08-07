package org.egen.io.movieFlix.service;

import java.util.List;

import org.egen.io.movieFlix.UserReviewsPK;
import org.egen.io.movieFlix.entity.UserReviews;

public interface UserReviewsService {

	public List<UserReviews> findAll();
	public UserReviews findOne(UserReviewsPK urwPK);
	public List<UserReviews> findMovieReviews(String imdbID);
	public UserReviews create(UserReviews urw);
	public UserReviews update(UserReviewsPK urw_pk,UserReviews urw);
	public void delete(UserReviewsPK urw_pk);
}
