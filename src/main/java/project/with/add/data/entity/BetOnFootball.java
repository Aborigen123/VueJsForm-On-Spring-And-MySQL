package project.with.add.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="betOnFootball")
public class BetOnFootball {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int uniqueId;
	
	private String choose;
	
	private int price;
	
	 @ManyToOne( fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	    @JoinColumn(name = "football_entity_id", nullable = true)
	    private FootballEntity footballEntity;

	public BetOnFootball(int id, int uniqueId, String choose, int price, FootballEntity footballEntity) {
		super();
		this.id = id;
		this.uniqueId = uniqueId;
		this.choose = choose;
		this.price = price;
		this.footballEntity = footballEntity;
	}

	public BetOnFootball() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getChoose() {
		return choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public FootballEntity getFootballEntity() {
		return footballEntity;
	}

	public void setFootballEntity(FootballEntity footballEntity) {
		this.footballEntity = footballEntity;
	}
	 
	 
}
