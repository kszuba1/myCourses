package io.github.kszuba1.dao;

import io.github.kszuba1.entity.Course;
import io.github.kszuba1.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAllByInstructor(Instructor instructor);

    List<Course> findAllByTitleContaining(String title);

    List<Course> findAllByTitleContainingAndInstructor(String title, Instructor instructor);

    boolean existsByTitle(String title);

    Optional<Course> findByTitle(String title);


}
