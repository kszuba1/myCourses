package io.github.kszuba1.service;

import io.github.kszuba1.entity.Student;
import io.github.kszuba1.entity.dto.StudentDTO;


public interface StudentService {

    void saveStudentDto(StudentDTO studentDTO);

    Student findByAccountUsername(String username);

    void save(Student student);

    boolean existsByNickname(String nickname);

}
