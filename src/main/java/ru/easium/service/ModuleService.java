package ru.easium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.easium.dao.CourseDAO;
import ru.easium.dao.StudentDAO;
import ru.easium.domain.Course;
import ru.easium.domain.Student;
import ru.easium.domain.Teacher;
import ru.easium.repository.TeacherRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class ModuleService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    public void createModule(Teacher teacher, List<Student> students, Course course) {
        teacherRepository.save(teacher);
        for (Student student : students) {
            studentDAO.save(student);
        }
        courseDAO.save(course);
    }
}
