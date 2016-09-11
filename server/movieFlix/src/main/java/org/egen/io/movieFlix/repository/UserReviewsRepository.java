package org.egen.io.movieFlix.repository;

import java.util.List;

import org.egen.io.movieFlix.UserReviewsPK;
import org.egen.io.movieFlix.entity.UserReviews;

public interface UserReviewsRepository {
	public List<UserReviews> findAll();

	public UserReviews findOne(UserReviewsPK urwPK);

	public List<UserReviews> findMovieReviews(String imdbID);
	
	public List<Object[]> findAvgMovieReviews();
	
	public List<UserReviews> findUserReviews(String userid);

	public UserReviews update(UserReviews urw);

	public UserReviews create(UserReviews urw);

	public void delete(UserReviews urw);
}
