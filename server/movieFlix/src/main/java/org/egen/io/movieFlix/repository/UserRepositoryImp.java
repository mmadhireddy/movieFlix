package org.egen.io.movieFlix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.egen.io.movieFlix.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImp implements UserRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class) ;
		return query.getResultList();
		
	}

	@Override
	public User findOne(String usrId) {
		return em.find(User.class, usrId);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> usrs = query.getResultList();
		if (usrs.size() == 1) {
			return usrs.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User update(User usr) {
		return em.merge(usr);
	}

	@Override
	public User create(User usr) {
		 em.persist(usr);
			return usr;
	}

	@Override
	public void delete(String id) {
		em.remove(id);
	}

}
