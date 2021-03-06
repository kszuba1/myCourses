package io.github.kszuba1.controller;

import io.github.kszuba1.entity.Course;
import io.github.kszuba1.entity.Instructor;
import io.github.kszuba1.entity.Review;
import io.github.kszuba1.service.CourseService;
import io.github.kszuba1.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import javax.validation.Valid;
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

        List<Course> courseList = instructor.getCourses();

        model.addAttribute("courses", courseList);

        model.addAttribute("searchTitle", new Course());

        return "home-page";
    }

    @PreAuthorize("principal.username.equals(@courseServiceImpl.findById(#id).instructor.account.username)")
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
    public String saveCourse(@Valid @ModelAttribute("course") Course course,
                             BindingResult bindingResult) {

        Course existingCourse = courseService.findByTitle(course.getTitle());

        if (existingCourse !=null && existingCourse.getId() != course.getId()) {
            bindingResult.addError(new FieldError("course", "title",
                    "Course with given title already exists"));

            return "course-form";
        }
        if (bindingResult.hasErrors()) {
            return "course-form";
        }

        courseService.save(course);

        return "redirect:/instructor/home";
    }

    @PreAuthorize("principal.username.equals(@courseServiceImpl.findById(#id).instructor.account.username)")
    @GetMapping("/updateCourse")
    public String updateCourse(@RequestParam("courseId") int id, Model model) {

        Course course = courseService.findById(id);

        model.addAttribute("course", course);

        return "course-form";
    }

    @GetMapping("/courseDetails")
    public String courseDetails(@RequestParam int id, Model model) {

        Course course = courseService.findById(id);

        model.addAttribute("course", course);

        List<Review> reviews = course.getReviews();

        model.addAttribute("reviews", reviews);

        return "course-details";
    }

    @GetMapping("/search")
    public String searchByTitle(@RequestParam("title") String title, Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Instructor instructor = instructorService.findByAccountUsername(auth.getName());

        List<Course> courses = courseService.findByTitleAndInstructor(title, instructor);

        model.addAttribute("courses", courses);

        Course searchCourse = new Course();

        searchCourse.setTitle(title);

        model.addAttribute("searchTitle", searchCourse);

        return "home-page";
    }


}
