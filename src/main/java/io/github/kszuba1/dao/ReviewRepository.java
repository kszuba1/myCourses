package io.github.kszuba1.dao;

import io.github.kszuba1.entity.Course;
import io.github.kszuba1.entity.Review;
import io.github.kszuba1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    boolean existsByCourseAndStudent(Course course, Student student);
}
