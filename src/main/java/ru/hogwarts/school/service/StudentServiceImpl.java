package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        Student newStudent = new Student(student.getName(), student.getAge());
        return studentRepository.save(newStudent);
    }

    @Override
    public Student getStudent(Long id) {
        if (!studentRepository.findAll().contains(id)) {
            throw new StudentNotFoundException(String.format("Student [%s] not found", id));
        }
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student updatingStudent = studentRepository.findById(id).get();
        updatingStudent.setName(student.getName());
        updatingStudent.setAge(student.getAge());
        return updatingStudent;
    }

    @Override
    public Student removeStudent(Long id) {
        Student studentForDelete = studentRepository.findById(id).get();
        studentRepository.delete(studentForDelete);
        return studentForDelete;
    }

    @Override
    public List<Student> getStudentByAge(int age) {
        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getAge() == age)
                .toList();
    }

    public List<Student> getWhenAgeBetween(Integer minAge, Integer maxAge) {
        return studentRepository.findAllByAgeBetween(minAge, maxAge);
    }
}
