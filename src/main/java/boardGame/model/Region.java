package boardGame.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//北中東南
@Entity
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regionId;
	
	private String region;
	
	@OneToMany(mappedBy = "region")
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
