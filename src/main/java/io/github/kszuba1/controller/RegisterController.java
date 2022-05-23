package io.github.kszuba1.controller;

import io.github.kszuba1.entity.dto.InstructorDTO;
import io.github.kszuba1.entity.dto.StudentDTO;
import io.github.kszuba1.service.InstructorService;
import io.github.kszuba1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/registerStudent")
    public String registerFormStudent(Model model){

        model.addAttribute("student", new StudentDTO());


        return "register-form-student";
    }

    @GetMapping("/registerInstructor")
    public String registerFormInstructor(Model model){

        model.addAttribute("instructor", new InstructorDTO());

        return "register-form-instructor";
    }

    @PostMapping("/saveStudent")
    public String studentSave(@ModelAttribute("student") StudentDTO studentDTO) {


        studentService.saveStudentDto(studentDTO);


        return "redirect:/loginStudent";
    }

    @PostMapping("/saveInstructor")
    public String instructorSave(@ModelAttribute("instructor") InstructorDTO instructorDTO) {


        instructorService.save(instructorDTO);


        return "redirect:/loginInstructor";
    }

}
