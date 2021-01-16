package boardGame.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

//縣市
@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;

	private String city;
	
	@ManyToOne
	@JsonIgnore
	private Region region;

	@OneToMany(mappedBy = "city", fetch=FetchType.EAGER)
	private Set<District> districts;

	public City() {
		super();
	}

	public City(String city, Region region) {
		super();
		this.city = city;
		this.region = region;
	}

	public Integer getCityId() {
		return cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Set<District> getDistricts() {
		return districts;
	}
	
}
