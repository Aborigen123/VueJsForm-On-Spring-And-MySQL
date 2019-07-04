package project.with.add.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "football")
public class FootballEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String typeGame;
	
	private String country;
	
	private String event;

	
	@OneToMany(mappedBy = "footballEntity", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY) 
	List<BetOnFootball> betOnFootball = new ArrayList<>();


	public FootballEntity(int id, String typeGame, String country, String event, List<BetOnFootball> betOnFootball) {
		super();
		this.id = id;
		this.typeGame = typeGame;
		this.country = country;
		this.event = event;
		this.betOnFootball = betOnFootball;
	}


	public FootballEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTypeGame() {
		return typeGame;
	}


	public void setTypeGame(String typeGame) {
		this.typeGame = typeGame;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getEvent() {
		return event;
	}


	public void setEvent(String event) {
		this.event = event;
	}


	public List<BetOnFootball> getBetOnFootball() {
		return betOnFootball;
	}


	public void setBetOnFootball(List<BetOnFootball> betOnFootball) {
		this.betOnFootball = betOnFootball;
	}


	
	
	
}
