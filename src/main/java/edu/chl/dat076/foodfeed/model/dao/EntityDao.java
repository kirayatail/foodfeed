package edu.chl.dat076.foodfeed.model.dao;

import java.io.*;
import java.util.*;

public interface EntityDao<T, ID extends Serializable> {

	T save(T entity);

	void delete(T entity);

	T findById(ID id);

	List<T> findAll();

}
