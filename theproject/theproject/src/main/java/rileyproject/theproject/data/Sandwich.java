/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rileyproject.theproject.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author riley
 */
@Entity
@Table(name = "SANDWICH")
//@Embeddable
public class Sandwich implements Serializable {
//    String sql = " CREATE TABLE SANDWICH (";
//            sql = sql + " NAME VARCHAR(50),";
//            sql = sql + " SHOP VARCHAR(50),";
//            sql = sql + " HOOD VARCHAR(50),";
//            sql = sql + " DESCRIPTION VARCHAR(500),";
//            sql = sql + " PRIMARY KEY (NAME, SHOP))"; 
        
    
   
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "NAME")
   @NotBlank(message = "Name cannot be blank")
   private String name;
   @Column(name = "SHOP")
   @NotBlank(message = "Shop cannot be blank")
   private String shop;
   @Column(name = "HOOD")
   @NotBlank(message = "Hood cannot be blank")
   private String hood;
   @Column(name = "DESCRIPTION")
   @NotBlank(message = "Description cannot be blank")
   private String description;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sandwich other = (Sandwich) obj;
        return Objects.equals(this.name, other.name);
    }
  

    @Override
    public String toString() {
        return "SandwichReviews{" + "name=" + name + ", shop=" + shop + ", hood=" + hood + '}';
    }

   
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getHood() {
        return hood;
    }

    public void setHood(String hood) {
        this.hood = hood;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

   

   