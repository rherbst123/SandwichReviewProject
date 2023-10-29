/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rileyproject.theproject.data;

import java.sql.SQLException;
import java.util.List;
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
public class ReviewController {
    
private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

            
    @Autowired
    reviewRepository reviewService;
    
    @GetMapping("/reviews")
    public ResponseEntity<Iterable<Review>> getAllReviews() throws SQLException {
        //get from repository
        Iterable<Review> sandwichreviews = reviewService.findAll();
        //return 
        return new ResponseEntity(sandwichreviews, HttpStatus.OK);
        
    }
    
     @GetMapping("/reviews/{sandname}")
    public ResponseEntity<List<Review>> getReviewBySandname(@PathVariable("sandname") String sandname) throws SQLException {
       
        //should be many...
        List<Review> result = reviewService.findBySandname(sandname);
        return new ResponseEntity(result, HttpStatus.OK);
}
    
//    @GetMapping("/reviews/bySandname/{sandname}")
//    public ResponseEntity<Review> getBySandname(@PathVariable("name") String sandname) throws SQLException {
//        //get them from the repository
//        Iterable<Review> reviews = reviewService.findBySandname(sandname);
//        //return them
//        return new ResponseEntity(reviews, HttpStatus.OK);
//      
//    }
    
    
    
    
  @PostMapping(value = "/reviews", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sandwich> insertReview(@RequestBody @Valid final Review reviews) {
        if (reviewService.existsById(reviews.getName())) {
            //already there
            return new ResponseEntity(reviews,HttpStatus.FOUND);
        } else {
            //add it
            reviewService.save(reviews);
            return new ResponseEntity(reviews,HttpStatus.OK);
        }
        
    }
    
    @PutMapping(value = "/reviews", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sandwich> updateReview(@RequestBody final Review reviews) throws SQLException {
        logger.info(reviews + "");
        //does it exist?
        if (reviewService.existsById(reviews.getName())) {
            //update
            reviewService.save(reviews);
            //already there
            return new ResponseEntity(reviews,HttpStatus.OK);
        } else {
            //add it
            
            return new ResponseEntity(reviews,HttpStatus.NOT_FOUND);
        }
        
    }
    
    
    @DeleteMapping("/reviews/{review}")
    public ResponseEntity<String> deleteReview(@PathVariable("review") String review) throws SQLException {
        
        if (reviewService.existsById(review)) {
            //delete it!
            reviewService.deleteById(review);
            //return result
            return new ResponseEntity(review, HttpStatus.OK);
        } else {
            //not there
            return new ResponseEntity(review, HttpStatus.NOT_FOUND);
        }
    }
}
    

