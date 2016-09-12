package org.egen.io.movieFlix.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.egen.io.movieFlix.UserReviewsPK;
import org.egen.io.movieFlix.entity.MediaList;
import org.egen.io.movieFlix.entity.User;
import org.egen.io.movieFlix.entity.UserReviews;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserReviewsRepositoryImp implements UserReviewsRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<UserReviews> findAll() {
		TypedQuery<UserReviews> query = em.createNamedQuery("UserReviews.findAll", UserReviews.class) ;
		return query.getResultList();
	}

	@Override
	public UserReviews findOne(UserReviewsPK urwPK) {
		return em.find(UserReviews.class, urwPK);
	}

	@Override
	public List<UserReviews> findMovieReviews(String imdbID) {
		TypedQuery<UserReviews> query = em.createNamedQuery("UserReviews.findMovieReview", UserReviews.class);
		query.setParameter("imdbid", imdbID);
		return query.getResultList();
		
	}
	
	@Override
	public List<UserReviews> findUserReviews(String userid) {
		TypedQuery<UserReviews> query = em.createNamedQuery("UserReviews.findUserReview", UserReviews.class);
		query.setParameter("userid", userid);
		return query.getResultList();
		
	}

	@Override
	@Transactional
	public UserReviews update(UserReviews urw) {
		User usr = em.find(User.class, urw.getUserid());
		MediaList mdl = em.find(MediaList.class, urw.getImdbid());
		urw.setMdl(mdl);
		urw.setUsr(usr);
		return em.merge(urw);
	}

	@Override
	@Transactional
	public UserReviews create(UserReviews urw) {
		User usr = em.find(User.class, urw.getUserid());
		MediaList mdl = em.find(MediaList.class, urw.getImdbid());
		urw.setMdl(mdl);
		urw.setUsr(usr);
		System.out.println(urw.toString());
		em.persist(urw);
		return urw;
	}

	@Override
	@Transactional
	public void delete(UserReviews urw) {
		
		em.remove(urw);
	}

	@Override
	public List<Object[]> findAvgMovieReviews() {
		List<Object[]> rawResultList;
		Query q = em.createNativeQuery("select u.imdbid , avg(rating) as avgRating from UserReviews u group by imdbid");
		rawResultList = q.getResultList();
		return rawResultList;
	} 

}
