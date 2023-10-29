/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rileyproject.theproject.data;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


/**
 *
 * @author riley
 */

public interface sandwichRepository extends CrudRepository<Sandwich, String> {
    
  //  List<Sandwich> FindAllName (String Name);
    
    List<Sandwich> findAll();
    
    List<Sandwich> findNameByShop(String shop);
    
    List<Sandwich> findByShop(String shop);

  
      
}
