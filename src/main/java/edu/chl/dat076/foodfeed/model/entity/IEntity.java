/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.model.entity;

import javax.persistence.Id;

/**
 *
 * @author max
 */
public interface IEntity {

    @Id
    String getId();
    
}
