package edu.chl.dat076.foodfeed.model.dao;

import java.io.*;
import java.util.*;

public interface EntityDao<T, ID extends Serializable> {

    public void create(T t);

    public void delete(T t);

    public void delete(ID id);

    public T find(ID id);

    public List<T> findAll();

    public void update(T t);
}
