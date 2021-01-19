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
public class ConvenienceStoreAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer convenienceStoreAddressId;

	private String convenienceStoreAddress;
	
	@ManyToOne
	private ConvenienceStoreType convenienceStoreType;

	@ManyToOne
	@JsonIgnore
	private Road road;

	public ConvenienceStoreAddress() {
		super();
	}

	public ConvenienceStoreAddress(String convenienceStoreAddress, ConvenienceStoreType convenienceStoreType,
			Road road) {
		super();
		this.convenienceStoreAddress = convenienceStoreAddress;
		this.convenienceStoreType = convenienceStoreType;
		this.road = road;
	}

	public String getConvenienceStoreAddress() {
		return convenienceStoreAddress;
	}

	public void setConvenienceStoreAddress(String convenienceStoreAddress) {
		this.convenienceStoreAddress = convenienceStoreAddress;
	}

	public Integer getConvenienceStoreAddressId() {
		return convenienceStoreAddressId;
	}

	public ConvenienceStoreType getConvenienceStoreType() {
		return convenienceStoreType;
	}

	public Road getRoad() {
		return road;
	}
	
}
