package project.with.add.data.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import project.with.add.data.dto.NameFilter;
import project.with.add.data.entity.FormEntity;
import project.with.add.data.repository.FormEntityRepository;
import project.with.add.data.service.FormEntityService;

@Service
public class FormEntityServiceImpl implements FormEntityService {

	@Autowired private FormEntityRepository formEntityRepository;
	@Override
	public List<FormEntity> findAll() {
	
		return formEntityRepository.findAll();
	}

	@Override
	public void saveFormEntity(FormEntity formEntity) {
     formEntityRepository.save(formEntity);
		
	}

	@Override
	public FormEntity findFormById(int id) {
		return formEntityRepository.findOne(id);
	}

	@Override
	public void deleteById(int id) {
		 formEntityRepository.delete(id);
		
	}

	@Override
	public Page<FormEntity> findByName(Pageable pageable, NameFilter nameFilter) {
		
		return formEntityRepository.findAll(getSpecification(nameFilter), pageable);
	}
	private Specification<FormEntity> getSpecification(NameFilter filter){
		return new Specification<FormEntity>() {

			@Override
			public Predicate toPredicate(Root<FormEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			if(filter.getName().isEmpty()) return null;
			
			return cb.like(root.get("name"), "%" + filter.getName() + "%");
			}
			
		};
	}


}
