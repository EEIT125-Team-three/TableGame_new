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

//鄉鎮市區
@Entity
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer districtId;

	private String district;
	
	@ManyToOne
	@JsonIgnore
	private City city;

	@OneToMany(mappedBy = "district", fetch=FetchType.EAGER)
	private Set<Road> Roads;
	
	public District() {
		super();
	}

	public District(String district, City city) {
		super();
		this.district = district;
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public Set<Road> getRoads() {
		return Roads;
	} 
	
}
