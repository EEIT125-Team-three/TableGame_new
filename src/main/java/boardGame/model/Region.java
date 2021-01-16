package boardGame.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

//北中東南
@Entity
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regionId;
	
	private String region;
	
	@OneToMany(mappedBy = "region", fetch=FetchType.EAGER)
	private Set<City> cities;
	
	public Region(String region) {
		super();
		this.region = region;
	}

	public Region() {
		super();
	}

	public Integer getRegionId() {
		return regionId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Set<City> getCities() {
		return cities;
	}
	
}
