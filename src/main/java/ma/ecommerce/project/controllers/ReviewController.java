package ma.ecommerce.project.controllers;


import ma.ecommerce.project.dto.ReviewDto;
import ma.ecommerce.project.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService IReviewService;

    @GetMapping
    public List<ReviewDto> getReviews() {
        return IReviewService.getReviews();
    }

    @PostMapping
    public void reviews(@RequestBody ReviewDto reviewDto) {
        IReviewService.createReview(reviewDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        try {
            IReviewService.deleteReview(id);
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussie
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found si le review n'existe pas
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody ReviewDto reviewDto) {
        try {
            IReviewService.updateReview(id, reviewDto);
            return ResponseEntity.ok("Review mise à jour avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
