package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Student20IT062;
import in.ac.charusat.studentmgmtsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
//    List<Student> students = new ArrayList<>(
//            Arrays.asList(
//                    new Student(1, "Tom", "US"),
//                    new Student(2, "Harry", "Canada"),
//                    new Student(3, "Nick", "UK")
//            )
//    );

    // Mappings - URL endpoints
    // Get the list of all student
    @GetMapping("/listStudents")
    public List<Student20IT062> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get the student information
    @GetMapping("/student/{id}")
    public Student20IT062 getStudent(@PathVariable Integer id) {
        return studentRepository.findById(id).get();
    }

    // Delete the student
    @DeleteMapping("/student/{id}")
    public List<Student20IT062> deleteStudent(@PathVariable Integer id) {
        studentRepository.delete(studentRepository.findById(id).get());
        return studentRepository.findAll();
    }

    // Add new student
    @PostMapping("/student")
    public List<Student20IT062> addStudent(@RequestBody Student20IT062 student20IT062) {
        studentRepository.save(student20IT062);
        return studentRepository.findAll();
    }

    // Update the student information
    @PutMapping("/student/{id}")
    public List<Student20IT062> updateStudent(@RequestBody Student20IT062 student20IT062, @PathVariable Integer id) {
        Student20IT062 student20IT062Obj = studentRepository.findById(id).get();
        student20IT062Obj.setName(student20IT062.getName());
        student20IT062Obj.setAddress(student20IT062.getAddress());
        studentRepository.save(student20IT062Obj);
        return studentRepository.findAll();
    }

}
