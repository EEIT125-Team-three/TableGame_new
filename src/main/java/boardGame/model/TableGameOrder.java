package boardGame.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
public class TableGameOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tableGameOrderId;
	
	private String greenCheckId;
	@OneToMany
	@JsonIgnore
	private List<ShopCar> shopCars;
	private String sentToWho;
	private String sentToAddress;
	private String sentToPhone;
	private Integer totalMoney;
	private Date checkoutDate;
	
	public TableGameOrder() {
		super();
	}

	public TableGameOrder(String greenCheckId, String sentToWho, String sentToAddress,
			String sentToPhone, Integer totalMoney, Date checkoutDate) {
		super();
		this.greenCheckId = greenCheckId;
		this.sentToWho = sentToWho;
		this.sentToAddress = sentToAddress;
		this.sentToPhone = sentToPhone;
		this.totalMoney = totalMoney;
		this.checkoutDate = checkoutDate;
	}


	public String getGreenCheckId() {
		return greenCheckId;
	}

	public void setGreenCheckId(String greenCheckId) {
		this.greenCheckId = greenCheckId;
	}

	public List<ShopCar> getShopCars() {
		return shopCars;
	}

	public void setShopCars(List<ShopCar> shopCars) {
		this.shopCars = shopCars;
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
	
}
