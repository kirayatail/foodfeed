package edu.chl.dat076.foodfeed.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.chl.dat076.foodfeed.model.entity.Recipe;

public class RecipeDao implements EntityDao<Recipe, Long> {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {

		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public Recipe save(Recipe recipe) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Recipe recipe) {
		// TODO Auto-generated method stub		
	}

	public Recipe findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Recipe> findAll() {
		// TODO Auto-generated method stub
	    return null;
	}

}
