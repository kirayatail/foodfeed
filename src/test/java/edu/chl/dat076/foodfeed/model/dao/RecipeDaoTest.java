/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.model.entity.Recipe;
import java.util.List;
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

    @Test
    public void testFindAll() {
        List<Recipe> recipes = recipeDao.findAll();
        assertTrue("check that true is true", true);
    }
}
