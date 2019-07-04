package project.with.add.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.with.add.data.entity.FootballEntity;

@Repository
public interface FootballRepository extends JpaRepository<FootballEntity, Integer>{

	@Query("select f from FootballEntity f where f.typeGame = :typeGame")
	FootballEntity findAllByTypeGame(@Param("typeGame")String typeGame);
	
	
	@Query("select f from FootballEntity f where f.country = :country")
	FootballEntity findFootballByCountry(@Param("country")String country);
	
	@Query("select f from FootballEntity f where f.event = :event")
	FootballEntity findFootballByEvent(@Param("event")String event);
	
	@Query("select f from FootballEntity f where f.country = :country and f.event = :event")
	FootballEntity findFootballByCountryAndEvent(@Param("country")String country, @Param("event")String event);
}
