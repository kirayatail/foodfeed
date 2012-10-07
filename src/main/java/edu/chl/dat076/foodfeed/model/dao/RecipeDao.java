package edu.chl.dat076.foodfeed.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.chl.dat076.foodfeed.model.entity.Recipe;
import org.hibernate.Query;

@Repository("recipeDao")
public class RecipeDao implements EntityDao<Recipe, Long> {

	@Autowired
	private SessionFactory sessionFactory;

        @Override
	public void save(Recipe recipe) {
		sessionFactory.getCurrentSession().saveOrUpdate(recipe);
	}

        @Override
	public void delete(Recipe recipe) {
		Query q = sessionFactory.getCurrentSession().createQuery("delete from Recipe r where id=:rid");
                q.setParameter("rid", recipe.getId());
                q.executeUpdate();
	}

        @Override
	public Recipe findById(Long id) {
		return (Recipe) sessionFactory.getCurrentSession().get(Recipe.class, id);
	}

	@SuppressWarnings("unchecked")
        @Override
	public List<Recipe> findAll() {
		return (List<Recipe>) sessionFactory.getCurrentSession().createQuery("from Recipe").list();
	}

}
