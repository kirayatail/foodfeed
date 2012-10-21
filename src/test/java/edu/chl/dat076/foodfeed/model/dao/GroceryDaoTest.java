package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.model.entity.Grocery;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
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
public class GroceryDaoTest {

    @Autowired
    GroceryDao groceryDao;
    public Grocery grocery;
    
    /*
     * Creates a Grocery Object to be used in tests
     */
    private Grocery createTestRecipeObject() {
        Grocery gy = new Grocery("Water", "Tap water");
        return gy;
    }

    @Before
    public void createRecipe() {
        grocery = createTestRecipeObject();
        groceryDao.create(grocery);
    }
    
    @Test
    public void getGrocery(){
        List<Grocery> result = groceryDao.getGrocery(grocery.getId());
        Assert.assertTrue("List is not empty", !result.isEmpty());
    }
}
