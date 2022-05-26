package io.github.kszuba1.controller;

import io.github.kszuba1.entity.Course;
import io.github.kszuba1.entity.Instructor;
import io.github.kszuba1.entity.Review;
import io.github.kszuba1.service.CourseService;
import io.github.kszuba1.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String instructorHome(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Instructor instructor = instructorService.findByAccountUsername(auth.getName());

        System.out.println(auth.getName());

        System.out.println(instructor);

        List<Course> courseList = instructor.getCourses();

        model.addAttribute("courses", courseList);

        model.addAttribute("searchTitle", new Course());

        return "home-page";
    }

    @GetMapping("/delete")
    public String deleteCourse(
            @RequestParam("courseId") int id) {

        courseService.deleteCourseById(id);

        return "redirect:/instructor/home";
    }

    @GetMapping("/addCourse")
    public String addCourse(Model model) {

        Course course = new Course();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Instructor instructor = instructorService.findByAccountUsername(auth.getName());

        course.setInstructor(instructor);

        model.addAttribute("course", course);

        return "course-form";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course){

        courseService.save(course);

        return "redirect:/instructor/home";
    }

    @GetMapping("/updateCourse")
    public String updateCourse(@RequestParam("courseId") int id, Model model){

        Course course = courseService.findById(id);

        model.addAttribute(course);

        return "course-form";
    }

    @GetMapping("/courseDetails")
    public String courseDetails(@RequestParam int id, Model model){

        Course course = courseService.findById(id);

        model.addAttribute("course", course);

        List<Review> reviews = course.getReviews();

        model.addAttribute("reviews", reviews);

        return "course-details";
    }



}
