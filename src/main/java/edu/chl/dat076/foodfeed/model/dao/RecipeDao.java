package edu.chl.dat076.foodfeed.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.chl.dat076.foodfeed.model.entity.Recipe;
import org.hibernate.Query;

@Repository("recipeDao")
public class RecipeDao extends AbstractDao<Recipe, Long> {

	@Autowired
	private SessionFactory sessionFactory;

        @Override
	public void save(Recipe recipe) {
            Query q = sessionFactory.getCurrentSession().createQuery("update Recipe set id=:id, name=:name, description=:desc where id=:id");
            q.setParameter("id", recipe.getId());
            q.setParameter("name", recipe.getName());
            q.setParameter("description", recipe.getDescription());
            q.executeUpdate();
	}

        @Override
	public void delete(Recipe recipe) {
            Query q = sessionFactory.getCurrentSession().createQuery("delete from Recipe r where id=:id");
            q.setParameter("id", recipe.getId());
            q.executeUpdate();
	}

        @Override
	public Recipe findById(Long id) {
            Query q = sessionFactory.getCurrentSession().createQuery("select r from Recipe r where id=:id");
            q.setParameter("id", id);
            return (Recipe) q.list().get(0);
	}

	@SuppressWarnings("unchecked")
        @Override
	public List<Recipe> findAll() {
		return (List<Recipe>) sessionFactory.getCurrentSession().createQuery("from Recipe").list();
	}

}
