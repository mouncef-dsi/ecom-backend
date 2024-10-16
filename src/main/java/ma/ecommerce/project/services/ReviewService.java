package ma.ecommerce.project.services;



import ma.ecommerce.project.entities.Product;
import ma.ecommerce.project.entities.Review;
import ma.ecommerce.project.dto.ReviewDto;
import ma.ecommerce.project.repositories.ProductRepository;
import ma.ecommerce.project.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService{

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<ReviewDto> getReviews() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewDto> reviewDtos = new ArrayList<ReviewDto>();
        reviews.forEach(review -> reviewDtos.add(new ReviewDto(review.getId(), review.getRating(), review.getCommentaire())));
        return reviewDtos;
    }
    public void createReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setRating(reviewDto.getRating());
        review.setCommentaire(reviewDto.getCommentaire());

        Optional<Product> productOpt = productRepository.findById(reviewDto.getIdProduct());
        if (productOpt.isEmpty()) {
            throw new IllegalArgumentException("Le produit avec l'identifiant " +reviewDto.getIdProduct() + " n'existe pas.");
        } else {
            Product product = productOpt.get();
            review.setProduct(product);
        }
        reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
        } else {
            throw new IllegalArgumentException("Le review avec l'identifiant " + reviewId + " n'existe pas.");
        }
    }

    public void updateReview(Long id, ReviewDto reviewDto) {
        Optional<Review> existingReview = reviewRepository.findById(id);

        if (existingReview.isPresent()) { // if address exists
            Review review = existingReview.get();
            review.setRating(reviewDto.getRating());
            review.setCommentaire(reviewDto.getCommentaire());
            reviewRepository.save(review);
        } else { // if address does not exist
            throw new IllegalArgumentException("Le review avec l'identifiant " + id + " n'existe pas.");
        }
    }

}
