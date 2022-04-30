package ru.math.tversu.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.math.tversu.studentapp.model.user.EducatorTitle;
import ru.math.tversu.studentapp.repository.user.TitleRepository;

import java.util.List;

@Service
public class TitleService {
	@Autowired
	private TitleRepository titleRepository;

	public List<EducatorTitle> getAll() {
		return titleRepository.findAll();
	}

	public EducatorTitle getById(Integer id) {
		return titleRepository.findById(id).orElse(new EducatorTitle());
	}

	public EducatorTitle createEntity() {
		return new EducatorTitle();
	}

	public EducatorTitle save(EducatorTitle title) {
		return titleRepository.save(title);
	}

	public void deleteById(Integer id) {
		titleRepository.deleteById(id);
	}

	public EducatorTitle getNotBoundToAnyTeacherById(Integer id) {
		return titleRepository.findOneNotBoundToAnyTeacherById(id);
	}
}
