package com.service4.review;

import com.service4.review.Model.Review;
import com.service4.review.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestParam String courseName, @RequestParam String userName, @RequestBody String reviewText) {
        try {
            Review review = new Review();
            review.setCourseName(courseName);
            review.setUserName(userName);
            review.setReviewText(reviewText);

            Review savedReview = reviewRepository.save(review);
            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        try {
            List<Review> reviews = reviewRepository.findAll();
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
     // Get all reviews
    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }*/
}
