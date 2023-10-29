/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rileyproject.theproject.data;

import java.sql.SQLException;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author riley
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SandwichController {
    
    
        private static final Logger logger = LoggerFactory.getLogger(SandwichController.class);
    
    @Autowired
    sandwichRepository sandwichService;
   // reviewRepository reviewService;
  
    
    
    @GetMapping("/sandwiches")
    public ResponseEntity<Iterable<Sandwich>> getAllSandwiches() throws SQLException {
        //get them from the repository
        Iterable<Sandwich> sandwichreviews= sandwichService.findAll();
        //return them
        return new ResponseEntity(sandwichreviews, HttpStatus.OK);
      
    }
   
    
    @GetMapping("/sandwiches/byshop/{shop}")
    public ResponseEntity<Iterable<Sandwich>> getByShop(@PathVariable("shop") String shop) throws SQLException {
        //get them from the repository
        Iterable<Sandwich> sandwichreviews = sandwichService.findByShop(shop);
        //return them
        return new ResponseEntity(sandwichreviews, HttpStatus.OK);
      
    }
    
//    @GetMapping("/sandwiches/byshop{shop}")
//    public ResponseEntity<Iterable<Sandwich>> geSandwichestByShop(@PathVariable("shop") String shop) throws SQLException {
//        //get them from the repository
//        Iterable<Sandwich> sandwichreviews = sandwichService.findByShop(shop);
//        //return them
//        return new ResponseEntity(sandwichreviews, HttpStatus.OK);
//      
//    }
   

   
    
//    @GetMapping("/reviews")
//    public ResponseEntity<Iterable<Review>> getAllReviews() throws SQLException {
//        //get from repository
//        Iterable<Review> sandwichreviews = reviewService.findAll();
//        //return 
//        return new ResponseEntity(sandwichreviews, HttpStatus.OK);
//        
//    }
    
    
    
    
  @PostMapping(value = "/sandwiches", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sandwich> insertSandwich(@RequestBody @Valid final Sandwich sandwich) {
        if (sandwichService.existsById(sandwich.getName())) {
            //already there
            return new ResponseEntity(sandwich,HttpStatus.FOUND);
        } else {
            //add it
            sandwichService.save(sandwich);
            return new ResponseEntity(sandwich,HttpStatus.OK);
        }
        
    }
    
    @PutMapping(value = "/sandwiches", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sandwich> updateSandwich(@RequestBody final Sandwich sandwich) throws SQLException {
        logger.info(sandwich + "");
        //does it exist?
        if (sandwichService.existsById(sandwich.getName())) {
            //update
            sandwichService.save(sandwich);
            //already there
            return new ResponseEntity(sandwich,HttpStatus.OK);
        } else {
            //add it
            
            return new ResponseEntity(sandwich,HttpStatus.NOT_FOUND);
        }
        
    }
    
    
    @DeleteMapping("/sandwiches/{name}")
    public ResponseEntity<String> deleteSandwich(@PathVariable("uid") String name) throws SQLException {
        
        if (sandwichService.existsById(name)) {
            //delete it!
            sandwichService.deleteById(name);
            //return result
            return new ResponseEntity(name, HttpStatus.OK);
        } else {
            //not there
            return new ResponseEntity(name, HttpStatus.NOT_FOUND);
        }
        
        
    }
    
    
    
}

 


