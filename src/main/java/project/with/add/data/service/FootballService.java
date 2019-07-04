package project.with.add.data.service;

import java.util.List;

import project.with.add.data.entity.FootballEntity;

public interface FootballService {

	void saveFootball(FootballEntity footballEntity);
	
	List<FootballEntity> allFootball();
	
	FootballEntity findFootballById(int id);
	
	FootballEntity findAllByTypeGame(String typeGame);

	FootballEntity findFootballByCountry(String country);
	
	FootballEntity findFootballByEvent(String event);
	
	FootballEntity findFootballByCountryAndEvent(String country, String event);
	
	
}
