package com.github.amanganiello90.javafullstack.db.h2.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.github.amanganiello90.javafullstack.app.models.SimpleTime;
import com.github.amanganiello90.javafullstack.app.repositories.SimpleTimeRepository;
import com.github.amanganiello90.javafullstack.db.h2.models.SimpleTimeJPA;

/**
 *
 * @author amanganiello90
 */

@Repository
public class SimpleTimeDAO implements SimpleTimeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	private List<SimpleTime> times;

	@Override
	public SimpleTime findById(String id) {
		// TODO Auto-generated method stub
		return entityManager.find(SimpleTimeJPA.class, id);

	}

	@Override
	@Transactional
	public SimpleTime save(SimpleTime time) {
		// TODO Auto-generated method stub
		SimpleTime object = this.findById(time.getId());
		if (object != null) {
			if (object.getId().equals(time.getId())) {
				entityManager.merge(time);
				return time;
			}
		}
		entityManager.persist(time);
		return time;
	}

	@Override
	public List<SimpleTime> findAll() {
		// TODO Auto-generated method stub
		// Query query = entityManager.createQuery("SELECT t FROM SimpleTimeJPA
		// t");
		TypedQuery<SimpleTimeJPA> query = entityManager.createQuery("from SimpleTimeJPA", SimpleTimeJPA.class);

		times = new ArrayList<SimpleTime>();

		List<SimpleTimeJPA> timesj = query.getResultList();
		for (int i = 0; i < timesj.size(); i++) {
			times.add(timesj.get(i));
		}
		return times;

	}

}
