package edu.chl.dat076.foodfeed.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Grocery implements IEntity<String>, Serializable {
        
        private String id;
        
        private String description;

        @Id
        @Override
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @NotNull
        @Size(min = 1, message = "The description must consist of at least one character")
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return this.id;
        }
}
