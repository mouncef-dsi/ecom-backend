package ma.ecommerce.project.services;


import ma.ecommerce.project.entities.Review;
import ma.ecommerce.project.dto.ReviewDto;
import ma.ecommerce.project.repositories.ProductRepository;
import ma.ecommerce.project.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

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

}
