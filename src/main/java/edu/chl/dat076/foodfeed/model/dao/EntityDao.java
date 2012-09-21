package edu.chl.dat076.foodfeed.model.dao;

import java.io.*;
import java.util.*;

public interface EntityDao<T, ID extends Serializable> {

	public void save(T entity);

	public void delete(T entity);

	public T findById(ID id);

	public List<T> findAll();

}
