package edu.chl.dat076.foodfeed.model.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * DAO class responsible for all methods that are common over DAOs
 * 
 * @author Kohina
 */
public abstract class AbstractDao<T, ID extends Serializable> implements EntityDao<T, ID> {

    @Override
    public void save(T entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(T entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T findById(ID id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
