package io.github.kszuba1.service;

import io.github.kszuba1.entity.Review;

public interface ReviewService {

    void save(Review review);

    void deleteById(int id);

    Review findById(int id);
}
