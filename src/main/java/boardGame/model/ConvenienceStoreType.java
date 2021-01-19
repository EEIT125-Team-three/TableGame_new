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
public class ConvenienceStoreType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer convenienceStoreId;

	private String convenienceStore;
	
	@OneToMany(mappedBy = "convenienceStoreType", fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<ConvenienceStoreAddress> convenienceStoreAddress;

	public ConvenienceStoreType() {
		super();
	}

	public ConvenienceStoreType(String convenienceStore) {
		super();
		this.convenienceStore = convenienceStore;
	}

	public String getConvenienceStore() {
		return convenienceStore;
	}

	public void setConvenienceStore(String convenienceStore) {
		this.convenienceStore = convenienceStore;
	}

	public Integer getConvenienceStoreId() {
		return convenienceStoreId;
	}

	public Set<ConvenienceStoreAddress> getConvenienceStoreAddress() {
		return convenienceStoreAddress;
	}
	
}
