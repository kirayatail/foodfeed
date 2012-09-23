package edu.chl.dat076.foodfeed.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.security.access.annotation.Secured;

import edu.chl.dat076.foodfeed.model.entity.Recipe;

public class RecipeDao implements EntityDao<Recipe, Long> {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public void save(Recipe recipe) {
		sessionFactory.openSession().saveOrUpdate(recipe);
	}

	public void delete(Recipe recipe) {
		// TODO Auto-generated method stub
	}

	public Recipe findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Recipe> findAll() {
		return sessionFactory.openSession().createQuery("from Recipe").list();
	}

}
