/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.model.entity.Grocery;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository("groceryDao")
public class GroceryDao extends AbstractDao<Grocery, String>{
    
    public GroceryDao(){
        super(Grocery.class);
    }
    
    public List<Grocery> getGrocery(String name){
        TypedQuery<Grocery> res = entityManager.createQuery("select g from Grocery g where g.id=:name", Grocery.class);
        res.setParameter("name", name);
        return res.getResultList();
    }
    
    
}
