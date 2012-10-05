package edu.chl.dat076.foodfeed.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.chl.dat076.foodfeed.model.entity.Recipe;

@Repository("recipeDao")
public class RecipeDao implements EntityDao<Recipe, Long> {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Recipe recipe) {
		sessionFactory.openSession().saveOrUpdate(recipe);
	}

	public void delete(Recipe recipe) {
		// TODO Auto-generated method stub
	}

	public Recipe findById(Long id) {
		Session session = sessionFactory.openSession();
		Recipe recipe = (Recipe) session.get(Recipe.class, id);
		session.close();
		return recipe;
	}

	@SuppressWarnings("unchecked")
	public List<Recipe> findAll() {
		return sessionFactory.openSession().createQuery("from Recipe").list();
	}

}
