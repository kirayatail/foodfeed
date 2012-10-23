package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.controller.rest.GroceryRestController;
import edu.chl.dat076.foodfeed.exception.ResourceNotFoundException;
import edu.chl.dat076.foodfeed.model.entity.*;
import edu.chl.dat076.foodfeed.model.service.RecipeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    @Autowired
    IUserDao userDao;
    
    public Recipe recipe;
    
    public User user;
    
    /*
     * Creates a Recipe Object to be used in tests
     */
    private Recipe createTestRecipeObject(){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(new Grocery("Red pepper", "Swedish red pepper"), 2.0, "stycken"));
        ingredients.add(new Ingredient(new Grocery("Water", "Tap water"), 20.0, "liter"));
        
        Recipe testrecipe = new Recipe();
        testrecipe.setDescription("Best soup in the world");
        testrecipe.setName("Soup");
        testrecipe.setIngredients(ingredients);
        testrecipe.setInstructions("Add all ingredients");
        return testrecipe;
    }
    
    /*
     * Creates a User to be used in tests
     */
    private User createTestUser(){
        User testuser = new User("Anders", "hej");
        return testuser;
    }
    
    @Before
    public void createRecipe(){
        recipe = createTestRecipeObject();
        user = createTestUser();
        recipe.setUser(user);
        user.getRecipes().add(recipe); 
        userDao.create(user);        
    }
    
    @Test
    public void testCreate(){
        Assert.assertNotNull("recipe could not be created", recipe.getId());
    }
    
    @Test(expected = ResourceNotFoundException.class)
    public void testDelete(){
        recipeDao.delete(recipe);
        Assert.assertNull("recipe removed", recipeDao.find(recipe.getId()));
    }
    
    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteID(){
        recipeDao.delete(recipe.getId());
        Assert.assertNull("recipe not removed", recipeDao.find(recipe.getId()));
    }
    
    @Test
    public void testFind(){
        Recipe result = recipeDao.find(recipe.getId());
        Assert.assertNotNull("recipe not found", result);
    }
    
    @Test
    public void testFindAll() {
        List<Recipe> recipes = recipeDao.findAll();
        Assert.assertFalse("List is not empty.", recipes.isEmpty());
    }
    
    @Test
    public void testUpdate(){
        Recipe old = new Recipe();
        old.setName(recipe.getName());
        recipe.setName("New name");
        recipeDao.update(recipe);
        Assert.assertNotSame("Recipe not updated", recipe.getName(), old.getName());
    }
    
    @Test
    public void testGetByGrocery(){
        List<Recipe> result = recipeDao.getByGrocery(recipe.getIngredients().get(0).getGrocery());
        Assert.assertFalse("found no recipe", result.isEmpty());
    }
    
    @Test
    public void testGetByName(){
        List<Recipe> result = recipeDao.getByName(recipe.getName());
        Assert.assertFalse("found no recipe", result.isEmpty());
    }
    
    @Test
    public void testGetByPartialName(){
        List<Recipe> result = recipeDao.getByName("ou");
        Assert.assertFalse("found no recipe", result.isEmpty());
    }
}
