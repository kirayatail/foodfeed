/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.mock;

import java.util.Collection;
import java.util.Map;

/**
 * This object corresponds to the KV-map object which sends data from
 * controllers to the JSP layer. For testing purposes only!
 */
public class Model implements org.springframework.ui.Model {
    
    public Map<String, Object> map;
    
    public Model(){
        this.map = new java.util.HashMap<>();
    }

    @Override
    public Model addAttribute(String string, Object o) {
        this.map.put(string, o);
        return this;
    }

    @Override
    public Model addAttribute(Object o) {
        return this;
    }

    @Override
    public Model addAllAttributes(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Model addAllAttributes(Map<String, ?> map) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Model mergeAttributes(Map<String, ?> map) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAttribute(String string) {
        return this.map.containsKey(string);
    }
    
    public Object get(String key){
        return this.map.get(key);
    }
    
    @Override
    public Map<String, Object> asMap() {
        return this.map;
    }
    
}
