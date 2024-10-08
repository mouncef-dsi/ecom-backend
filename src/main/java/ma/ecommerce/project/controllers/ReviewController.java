package ma.ecommerce.project.controllers;



import ma.ecommerce.project.dto.ReviewDto;

import ma.ecommerce.project.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> getReviews() {
        return reviewService.getReviews();
    }
}
