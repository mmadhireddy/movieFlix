package org.egen.io.movieFlix.service;

import java.util.List;

import org.egen.io.movieFlix.UserReviewsPK;
import org.egen.io.movieFlix.entity.MediaList;

public interface MediaListService {
	public List<MediaList> findAll();
	public MediaList findOne(String imdbID);
	public MediaList create(String userid,MediaList usr);
	public MediaList update(UserReviewsPK urw_pk,MediaList mdl);
	public void  delete(UserReviewsPK urw_pk);

}
