package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courselist")
    public List<Course> getAllCourses() { return courseRepository.findAll(); }

    @GetMapping("/courselist/{id}")
    public Course getCourse(@PathVariable Integer id ) { return courseRepository.findById(id).get(); }

    @DeleteMapping("/courselist/{id}")
    public List<Course> deleteCourse(@PathVariable Integer id) { courseRepository.delete(courseRepository.findById(id).get());
        return courseRepository.findAll();
    }

    @PostMapping("/courselist/{id}")
    public List<Course>  addCourse(@RequestBody Course courselist){
        courseRepository.save(courselist);
        return courseRepository.findAll();
    }
    @PutMapping("/courselist/{id}")
    public List<Course> updateCourse(@RequestBody Course courselist, @PathVariable Integer id) {
        Course courselistObj = courseRepository.findById(id).get();
        courselistObj.setId(courselist.getId());
        courselistObj.setTitle(courselist.getTitle());
        courseRepository.save(courselistObj);
        return courseRepository.findAll();
    }
}