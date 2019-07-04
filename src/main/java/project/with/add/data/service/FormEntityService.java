package project.with.add.data.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import project.with.add.data.dto.NameFilter;
import project.with.add.data.entity.FormEntity;

public interface FormEntityService {

	List<FormEntity> findAll();
	
	void saveFormEntity(FormEntity formEntity);
	
	FormEntity findFormById(int id);
	
	void deleteById(int id);
	
	Page<FormEntity>findByName(Pageable pageable, NameFilter nameFilter);
}
