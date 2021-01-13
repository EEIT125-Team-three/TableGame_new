package boardGame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//鄉鎮市區
@Entity
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer districtId;

	private String district;
	
	@ManyToOne
	private City city;

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
}
