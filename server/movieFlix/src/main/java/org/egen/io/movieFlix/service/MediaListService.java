package org.egen.io.movieFlix.service;

import java.util.List;

import org.egen.io.movieFlix.entity.MediaList;

public interface MediaListService {
	public List<MediaList> findAll();
	public MediaList findOne(String imdbID);
	public MediaList create(MediaList usr);
	public MediaList update(String imdbID,MediaList mdl);
	public void  delete(String imdbID);

}
