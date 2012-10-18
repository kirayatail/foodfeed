package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.model.entity.Grocery;
import edu.chl.dat076.foodfeed.model.entity.Ingredient;
import edu.chl.dat076.foodfeed.model.entity.Recipe;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath*:spring/root-context.xml",
    "classpath*:spring/security-context.xml"})
@Transactional
public class RecipeDaoTest {

    @Autowired
    RecipeDao recipeDao;

    /*
     * Creates a Recipe Object to be used in tests
     */
    private Recipe createTestRecipeObject(){
        List<Ingredient> ingredients = new ArrayList();
        ingredients.add(new Ingredient(new Grocery("Red pepper", "Swedish red pepper"), 2.0, "stycken"));
        ingredients.add(new Ingredient(new Grocery("Water", "Tap water"), 20.0, "liter"));
        
        Recipe recipe = new Recipe();
        recipe.setDescription("Best soup in the world");
        recipe.setName("Soup");
        recipe.setIngredients(ingredients);
        return recipe;
    }
    
    @Test
    public void testCreate(){
        Recipe recipe = createTestRecipeObject();
        recipeDao.create(recipe);
        Assert.assertNotNull("recipe could not be created", recipe.getId());
    }
    
    @Test
    public void testDelete(){
        Recipe recipe = createTestRecipeObject();
        recipeDao.create(recipe);
        recipeDao.delete(recipe);
        Assert.assertNull("recipe removed", recipe.getId());
    }
    
    @Test
    public void testDeleteID(){
        Recipe recipe = createTestRecipeObject();
        recipeDao.create(recipe);
        recipeDao.delete(recipe.getId());
        Assert.assertNull("recipe not removed", recipe.getId());
    }
    
    @Test
    public void testFind(){
        Recipe recipe = createTestRecipeObject();
        recipeDao.create(recipe);
        Recipe result = recipeDao.find(recipe.getId());
        Assert.assertNotNull("recipe not found", result);
    }
    
    @Test
    public void testFindAll() {
        List<Recipe> recipes = recipeDao.findAll();
        assertTrue("check that true is true", true);
    }
    
    @Test
    public void testUpdate(){
        Recipe recipe = createTestRecipeObject();
        recipeDao.create(recipe);
        Recipe old = recipe;
        recipe.setName("New name");
        recipeDao.update(recipe);
        Assert.assertNotSame("recipe not updated", recipe.getName(), old.getName());
    }
    
    @Test
    public void testGetByIngredient(){
        Recipe recipe = createTestRecipeObject();
        recipeDao.create(recipe);
        List<Recipe> result = recipeDao.getByIngredient(recipe.getIngredients().get(0));
        Assert.assertTrue("found no recipe", !result.isEmpty());
    }
    
    @Test
    public void testGetByName(){
        Recipe recipe = createTestRecipeObject();
        recipeDao.create(recipe);
        List<Recipe> result = recipeDao.getByName(recipe.getName());
        Assert.assertTrue("found no recipe", !result.isEmpty());
    }
}
