package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.model.entity.Grocery;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/*
 * Implements CRUD specific to the entity Grocery
 */
@Repository("groceryDao")
public class GroceryDao extends AbstractDao<Grocery, String>{
    
    public GroceryDao(){
        super(Grocery.class);
    }
    
    public List<String> getGroceries(String name){
        TypedQuery<String> res = entityManager.createQuery("select g.id from Grocery g "
                + "where lower(g.id) like lower(:name)", String.class);
        res.setParameter("name", "%" + name + "%");
        return res.getResultList();
    }
    
    
}
