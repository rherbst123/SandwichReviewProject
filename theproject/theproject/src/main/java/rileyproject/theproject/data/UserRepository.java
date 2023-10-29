/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rileyproject.theproject.data;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mruth
 */
public interface UserRepository extends CrudRepository<Users, String>{

   List<Users> findAll();
    
}
