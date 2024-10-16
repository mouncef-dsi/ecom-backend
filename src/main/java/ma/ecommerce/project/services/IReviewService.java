package ma.ecommerce.project.services;

import ma.ecommerce.project.dto.ReviewDto;
import java.util.List;

public interface IReviewService {

    List<ReviewDto> getReviews();

    void createReview(ReviewDto reviewDto);

    void deleteReview(Long reviewId);

    void updateReview(Long id, ReviewDto reviewDto);
}
