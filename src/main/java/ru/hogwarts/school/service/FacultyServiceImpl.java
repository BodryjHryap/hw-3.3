package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override

    public Faculty addFaculty(Faculty faculty) {
        Faculty newFaculty = new Faculty(faculty.getName(), faculty.getColor());
        return facultyRepository.save(newFaculty);
    }

    @Override
    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).get();
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        Faculty updatingFaculty = facultyRepository.findById(id).get();
        updatingFaculty.setName(faculty.getName());
        updatingFaculty.setColor(faculty.getColor());
        return updatingFaculty;
    }

    @Override
    public Faculty removeFaculty(Long id) {
        Faculty facultyForDelete = facultyRepository.findById(id).get();
        facultyRepository.delete(facultyForDelete);
        return facultyForDelete;
    }

    @Override
    public List<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findAll()
                .stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .toList();
    }
}
