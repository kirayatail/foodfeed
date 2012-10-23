package edu.chl.dat076.foodfeed.model.entity;

import java.io.Serializable;

public interface IEntity<ID extends Serializable> {

    public ID getId();

    public void setId(ID id);
}
