package org.egen.io.movieFlix.repository;

import java.util.List;

import org.egen.io.movieFlix.entity.MediaList;


public interface MediaListRepository {
	public List<MediaList> findAll();

	public MediaList findOne(String imdbID);


	public MediaList update(MediaList mdl);

	public MediaList create(MediaList mdl);

	public void delete(MediaList mdl);
}
