package boardGame.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TableGameOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tableGameOrderId;
	
	private String greenCheckId;
	
	@OneToMany(mappedBy = "tableGameOrderId", cascade = CascadeType.ALL)
	@JsonIgnore
	Set<ShopCar> shopCars  = new HashSet<>();
	private String sentToWho;
	private String sentToAddress;
	private String sentToPhone;
	private Integer totalMoney;
	private Date checkoutDate;
	@ManyToOne
	@JsonIgnore
	private MemberBean memberId;
	@ManyToOne
	@JsonIgnore
	private Road road;
	@ManyToOne
	@JsonIgnore
	private ConvenienceStoreAddress convenienceStoreAddress;
	
	public TableGameOrder() {
		super();
	}

	public TableGameOrder(String greenCheckId, String sentToWho, String sentToAddress, String sentToPhone,
			Integer totalMoney, Date checkoutDate, MemberBean memberId, Road road,
			ConvenienceStoreAddress convenienceStoreAddress) {
		super();
		this.greenCheckId = greenCheckId;
		this.sentToWho = sentToWho;
		this.sentToAddress = sentToAddress;
		this.sentToPhone = sentToPhone;
		this.totalMoney = totalMoney;
		this.checkoutDate = checkoutDate;
		this.memberId = memberId;
		this.road = road;
		this.convenienceStoreAddress = convenienceStoreAddress;
	}

	public String getGreenCheckId() {
		return greenCheckId;
	}

	public void setGreenCheckId(String greenCheckId) {
		this.greenCheckId = greenCheckId;
	}

	public String getSentToWho() { 
		return sentToWho;
	}

	public void setSentToWho(String sentToWho) {
		this.sentToWho = sentToWho;
	}

	public String getSentToAddress() {
		return sentToAddress;
	}

	public void setSentToAddress(String sentToAddress) {
		this.sentToAddress = sentToAddress;
	}

	public String getSentToPhone() {
		return sentToPhone;
	}

	public void setSentToPhone(String sentToPhone) {
		this.sentToPhone = sentToPhone;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Integer getTableGameOrderId() {
		return tableGameOrderId;
	}

	public void setTableGameOrderId(Integer tableGameOrderId) {
		this.tableGameOrderId = tableGameOrderId;
	}

	public Integer getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Set<ShopCar> getShopCars() {
		return shopCars;
	}

	public void setShopCars(Set<ShopCar> shopCars) {
		this.shopCars = shopCars;
	}

	public void setMemberId(MemberBean memberId) {
		this.memberId = memberId;
	}

	public Road getRoad() {
		return road;
	}

	public void setRoad(Road road) {
		this.road = road;
	}

	public MemberBean getMemberId() {
		return memberId;
	}

	public ConvenienceStoreAddress getConvenienceStoreAddress() {
		return convenienceStoreAddress;
	}

	public void setConvenienceStoreAddress(ConvenienceStoreAddress convenienceStoreAddress) {
		this.convenienceStoreAddress = convenienceStoreAddress;
	}
	
}
