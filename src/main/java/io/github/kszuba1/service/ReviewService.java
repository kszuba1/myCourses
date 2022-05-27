package io.github.kszuba1.service;

import io.github.kszuba1.entity.Course;
import io.github.kszuba1.entity.Review;
import io.github.kszuba1.entity.Student;

public interface ReviewService {

    void save(Review review);

    void deleteById(int id);

    Review findById(int id);

    boolean existsByCourseAndStudent(Course course, Student student);
}
