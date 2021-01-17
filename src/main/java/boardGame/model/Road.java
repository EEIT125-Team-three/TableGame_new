package boardGame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//鄉鎮市區
@Entity
public class Road {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roadId;
	
	@Column(columnDefinition="nvarchar(MAX)" , nullable = false)
	private String road;
	
	@ManyToOne
	@JsonIgnore
	private District district;

	public Road() {
		super();
	}

	public Road(String road, District district) {
		super();
		this.road = road;
		this.district = district;
	}

	public Integer getRoadId() {
		return roadId;
	}

	public void setRoadId(Integer roadId) {
		this.roadId = roadId;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public District getDistrict() {
		return district;
	}
	
}
