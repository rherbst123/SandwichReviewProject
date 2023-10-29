/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rileyproject.theproject.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author riley
 */
@Entity
@Table(name = "REVIEW")
public class Review implements Serializable {
   
    
    @EmbeddedId
    @NotBlank(message = "Name cannot be blank")
    private SandwichNames sandname;
    
    

//    @Column(name ="SHOP")
//    private String shop;
    
    @Column(name = "REVIEW")
    @NotBlank(message = "Review cannot be blank")
    private String review;
    @Column(name = "STARS")
    @NotBlank(message = "stars cannot be blank")
    private double stars;

  
    
    @Override
    public String toString() {
        return "Review{" + "sandname=" + this.sandname.name + ", sanduser=" + this.sandname.user + ", sandshop=" + this.sandname.shop + ", review=" + review + ", stars=" + stars + '}';
    }


    
    public String getName() {
        return this.sandname.name;
    }

    public void setName(String sandname) {
        this.sandname.name = sandname;
    }

    public String getUser() {
        return this.sandname.user;
    }

    public void setUserser(String sanduser) {
        this.sandname.user = sanduser;
    }

    public String getShop() {
        return this.sandname.shop;
    }

    public void setShop(String sandshop) {
        this.sandname.shop = sandshop;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }
}

    