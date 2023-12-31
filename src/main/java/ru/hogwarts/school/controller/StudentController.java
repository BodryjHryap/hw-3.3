package ru.hogwarts.school.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public Student removeStudent(@PathVariable Long id) {
        return studentService.removeStudent(id);
    }

    @GetMapping
    public Collection<Student> getStudentsByAge(@RequestParam Integer age) {
        return studentService.getStudentByAge(age);
    }

    @GetMapping("/age-between")
    public List<Student> getWhenAgeBetween(@RequestParam Integer minAge, @RequestParam Integer maxAge) {
        return studentService.getWhenAgeBetween(minAge, maxAge);
    }
}
