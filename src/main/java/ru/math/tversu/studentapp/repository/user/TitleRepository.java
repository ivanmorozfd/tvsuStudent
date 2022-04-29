package ru.math.tversu.studentapp.repository.user;

import org.springframework.data.repository.CrudRepository;
import ru.math.tversu.studentapp.model.user.EducatorTitle;

import java.util.List;

public interface TitleRepository extends CrudRepository<EducatorTitle, Integer> {
    List<EducatorTitle> findAll();
    EducatorTitle findFirstByOrderByIdDesc();
}
