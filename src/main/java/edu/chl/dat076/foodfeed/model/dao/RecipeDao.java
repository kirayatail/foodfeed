package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.model.entity.Grocery;
import edu.chl.dat076.foodfeed.model.entity.Ingredient;
import edu.chl.dat076.foodfeed.model.entity.Recipe;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/*
 * Implements CRUD specific to the entity Recipe
 */
@Repository("recipeDao")
public class RecipeDao extends AbstractDao<Recipe, Long> implements IRecipeDao {

    RecipeDao() {
        super(Recipe.class);
    }

    @Override
    public void create(Recipe r) {
        for (Ingredient i : r.getIngredients()) {
            this.entityManager.merge(i.getGrocery());
        }
        super.create(r);
    }

    @Override
    public void update(Recipe r) {
        for (Ingredient i : r.getIngredients()) {
            this.entityManager.merge(i.getGrocery());
        }
        super.update(r);
    }

    @Override
    public List<Recipe> getByGrocery(Grocery g) {
        TypedQuery<Recipe> res = entityManager.createQuery("select r from Recipe r "
                + "left join r.ingredients as i "
                + "where i.grocery = :grocery)", Recipe.class);
        res.setParameter("grocery", g);
        return res.getResultList();
    }

    @Override
    public List<Recipe> getByName(String name) {
        TypedQuery<Recipe> res = entityManager.createQuery("select r from Recipe r "
                + "where lower(r.name) like lower(:name)", Recipe.class);
        res.setParameter("name", "%" + name + "%");
        return res.getResultList();
    }
}
