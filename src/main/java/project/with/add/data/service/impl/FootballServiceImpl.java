package project.with.add.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.with.add.data.entity.FootballEntity;
import project.with.add.data.repository.FootballRepository;
import project.with.add.data.service.FootballService;

@Service
public class FootballServiceImpl implements FootballService{

	@Autowired private FootballRepository footballRepository;
	
	@Override
	public void saveFootball(FootballEntity footballEntity) {
		footballRepository.save(footballEntity);
		
	}

	@Override
	public List<FootballEntity> allFootball() {

		return footballRepository.findAll();
	}

	@Override
	public FootballEntity findFootballById(int id) {

		return footballRepository.findOne(id);
	}

	@Override
	public FootballEntity findAllByTypeGame(String typeGame) {
		
		return footballRepository.findAllByTypeGame(typeGame);
	}

	@Override
	public FootballEntity findFootballByCountry(String country) {
	
		return footballRepository.findFootballByCountry(country);
	}

	@Override
	public FootballEntity findFootballByEvent(String event) {
		
		return footballRepository.findFootballByEvent(event);
	}

	@Override
	public FootballEntity findFootballByCountryAndEvent(String country, String event) {
	
		return footballRepository.findFootballByCountryAndEvent(country, event);
	}


}
