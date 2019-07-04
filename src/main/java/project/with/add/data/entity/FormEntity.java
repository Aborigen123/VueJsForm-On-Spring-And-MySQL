package project.with.add.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form")
public class FormEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int age;
	
	private String things;

	public FormEntity(int id, String name, int age, String things) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.things = things;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getThings() {
		return things;
	}

	public void setThings(String things) {
		this.things = things;
	}

	public FormEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormEntity(String name, int age, String things) {
		super();
		this.name = name;
		this.age = age;
		this.things = things;
	}

	public FormEntity(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "FormEntity [id=" + id + ", name=" + name + ", age=" + age + ", things=" + things + "]";
	}

	public FormEntity(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	
}
