package edu.chl.dat076.foodfeed.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<T, ID extends Serializable> implements
        EntityDao<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;
    private Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void create(T t) {
        entityManager.persist(t);
    }

    @Override
    public void delete(T t) {
        entityManager.remove(t);
    }
    
    @Override
    public void delete(ID id){
        entityManager.createQuery("delete e from "+clazz.getSimpleName()+" e where e.id="+id, clazz).executeUpdate();
        
    }

    @Override
    public T find(ID id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
    }

    @Override
    public void update(T t) {
        entityManager.refresh(t);
    }
}
