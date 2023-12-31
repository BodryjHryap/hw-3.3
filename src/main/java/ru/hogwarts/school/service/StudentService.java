package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    Student getStudent(Long id);

    Student updateStudent(Long id, Student student);

    Student removeStudent(Long id);

    List<Student> getStudentByAge(int age);

    List<Student> getWhenAgeBetween(Integer minAge, Integer maxAge);

}
