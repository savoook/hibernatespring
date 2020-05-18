import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easium.domain.Teacher;
import ru.easium.service.CourseService;
import ru.easium.service.TeacherService;

public class MainSpringDAO {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        CourseService courseService = context.getBean(CourseService.class);
        System.out.println(courseService.findAllCourses());

        TeacherService teacherService = context.getBean(TeacherService.class);
        teacherService.saveTeacher(new Teacher("Иван Сидоров", "Заслуженный учитель", null));
        System.out.println(teacherService.findAll());
        System.out.println("findTeacherByFio--> " + teacherService.findTeacherByFio("Иван Иванов"));
        System.out.println("findTeacherByAbout--> " + teacherService.findTeacherByAbout("Заслуженный"));
    }
}
