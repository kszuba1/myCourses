package io.github.kszuba1.service;

import io.github.kszuba1.entity.Instructor;
import io.github.kszuba1.entity.dto.InstructorDTO;

public interface InstructorService {

    void save(InstructorDTO instructorDTO);

    Instructor findByAccountUsername(String username);
}
