/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.model.entity;

import java.io.Serializable;
import javax.persistence.Id;

/**
 *
 * @author max
 */
public interface IEntity<ID extends Serializable> {

    public ID getId();

    public void setId(ID id);
}
