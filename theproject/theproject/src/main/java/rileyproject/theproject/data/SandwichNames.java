/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rileyproject.theproject.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author riley
 */
@Embeddable
public class SandwichNames implements Serializable  {
    
    protected String name;
    
    protected String shop;
    
    protected String user;
    
    
     public SandwichNames(){
        
        
    }
    
    public SandwichNames(String name,  String user, String shop){
        this.name = name;
        this.shop = shop;
        this.user = user;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.shop);
        hash = 17 * hash + Objects.hashCode(this.user);
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
        final SandwichNames other = (SandwichNames) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.shop, other.shop)) {
            return false;
        }
        return Objects.equals(this.user, other.user);
    }
}
    
    

    