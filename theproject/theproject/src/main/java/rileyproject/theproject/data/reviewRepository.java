/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rileyproject.theproject.data;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author riley
 */
public interface reviewRepository extends CrudRepository<Review, String> {
    
   
    List<Review> findAll();
    
   // List<Review> findBySandname(String name);
    
   // List<Review> findRevivewBySandname (String sandname);
    
  
        
    @Query(value = "SELECT * FROM REVIEW WHERE NAME = ?1", nativeQuery = true)
    List<Review> findBySandname(String name);
    
}
