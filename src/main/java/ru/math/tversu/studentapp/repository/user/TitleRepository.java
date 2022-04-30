package ru.math.tversu.studentapp.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.user.EducatorTitle;

import java.util.List;

public interface TitleRepository extends CrudRepository<EducatorTitle, Integer> {
    List<EducatorTitle> findAll();

    EducatorTitle findFirstByOrderByIdDesc();

    @Query("SELECT title FROM EducatorTitle title WHERE title.id = :id AND (SELECT COUNT(teacher) FROM Teacher teacher WHERE teacher.title = title) < 1")
    EducatorTitle findOneNotBoundToAnyTeacherById(Integer id);
}
