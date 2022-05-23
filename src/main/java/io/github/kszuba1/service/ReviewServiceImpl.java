package io.github.kszuba1.service;

import io.github.kszuba1.dao.ReviewRepository;
import io.github.kszuba1.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void save(Review review) {

        reviewRepository.save(review);

    }

    @Override
    public void deleteById(int id) {

        reviewRepository.deleteById(id);
    }

    @Override
    public Review findById(int id) {
        Optional<Review> resultReview = reviewRepository.findById(id);

        Review review = null;

        if (resultReview.isPresent()) {
            review = resultReview.get();
        }
        else {
            throw new RuntimeException("Review with Id = " + id + " not found");
        }

        return review;
    }
}
