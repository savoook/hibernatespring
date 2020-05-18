package ru.easium.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.easium.domain.Teacher;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    public List<Teacher> findByFio(String fio);

    @Query("select t from Teacher t where about like %?1%")
    public List<Teacher> findByAboutPartialMatch(String about);

}
