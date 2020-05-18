import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easium.domain.Course;
import ru.easium.domain.Student;
import ru.easium.domain.Teacher;
import ru.easium.service.ModuleService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTransactional {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ModuleService moduleService = context.getBean(ModuleService.class);

        Course junior = new Course("Java junior", 65);
        List<Course> courses = new ArrayList<>();
        courses.add(junior);

        Student student = new Student("John", new Date(123), 1000L, courses);
        junior.setStudent(student);
        List<Student> students = new ArrayList<>();
        students.add(student);

        Teacher teacher = new Teacher("Петров Петр", "about", courses);

        moduleService.createModule(teacher, students, junior);
    }
}
