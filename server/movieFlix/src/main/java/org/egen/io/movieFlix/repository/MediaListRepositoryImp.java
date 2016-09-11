package org.egen.io.movieFlix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.egen.io.movieFlix.entity.MediaList;
import org.springframework.stereotype.Repository;

@Repository
public class MediaListRepositoryImp implements MediaListRepository{
	
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<MediaList> findAll() {
		TypedQuery<MediaList> query = em.createNamedQuery("MediaList.findAll", MediaList.class) ;
		List<MediaList> mdl = query.getResultList();
		return mdl;
	}

	@Override
	public MediaList findOne(String imdbID) {
		return em.find(MediaList.class, imdbID);
	}



	@Override
	public MediaList update(MediaList mdl) {
		return em.merge(mdl);
	}

	@Override
	public MediaList create(MediaList mdl) {
		 em.persist(mdl);
			return mdl;
	}

	@Override
	public void delete(MediaList mdl) {
		em.remove(mdl);
	}

}
