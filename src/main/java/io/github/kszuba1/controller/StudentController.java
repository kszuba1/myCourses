package io.github.kszuba1.controller;

import io.github.kszuba1.entity.Course;
import io.github.kszuba1.entity.Review;
import io.github.kszuba1.entity.Student;
import io.github.kszuba1.service.CourseService;
import io.github.kszuba1.service.ReviewService;
import io.github.kszuba1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/studentPage")
    public String studentHome(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<Course> courses = courseService.findAll();

        model.addAttribute("courses", courses);

        Student student = studentService.findByAccountUsername(auth.getName());

        System.out.println(student.getCourses());

        model.addAttribute("searchTitle", new Course());

        return "student-page";
    }

    @GetMapping("/courseDetails")
    public String courseDetails(@RequestParam int id, Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Course course = courseService.findById(id);

        model.addAttribute("course", course);

        List<Review> reviews = course.getReviews();

        model.addAttribute("reviews", reviews);

        Student student = studentService.findByAccountUsername(auth.getName());

        Review newReview = new Review();

        newReview.setStudent(student);

        newReview.setCourse(course);

        model.addAttribute("review", newReview);


        return "course-details";
    }


    @GetMapping("/signUp")
    public String signUpFor(@RequestParam("courseId") int id, RedirectAttributes redirAttrs) {

        Course course = courseService.findById(id);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Student student = studentService.findByAccountUsername(auth.getName());

        if (student.getCourses().contains(course)) {

            redirAttrs.addFlashAttribute("error", "You are already signed up for this course!");

            return "redirect:/student/studentPage";
        }

        course.addStudent(student);

        courseService.save(course);

        redirAttrs.addFlashAttribute("success", "You have successfully signed up for a course.");

        return "redirect:/student/studentPage";
    }


    @PostMapping("/addReview")
    public String addReview(@ModelAttribute("review") Review review) {

        System.out.println(review.getRate());

        reviewService.save(review);

        return "redirect:/student/courseDetails?id=" + review.getCourse().getId();
    }

    @GetMapping("/deleteReview")
    public String deleteReview(@RequestParam("reviewId") int id){

        Course course = reviewService.findById(id).getCourse();

        reviewService.deleteById(id);

        return "redirect:/student/courseDetails?id=" + course.getId();
    }

    @GetMapping("/yourCourses")
    public String showYourCourses(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Student student = studentService.findByAccountUsername(auth.getName());

        List<Course> courses = student.getCourses();

        System.out.println(courses);

        model.addAttribute("courses", courses);

        model.addAttribute("searchTitle", new Course());

        return "student-page";
    }

    @GetMapping("/search")
    public String searchByTitle(@RequestParam("title") String title, Model model) {

        List<Course> courses = courseService.findByTitle(title);

        model.addAttribute("courses", courses);

        Course searchCourse = new Course();

        searchCourse.setTitle(title);

        model.addAttribute("searchTitle", searchCourse);

        return "student-page";
    }

}
