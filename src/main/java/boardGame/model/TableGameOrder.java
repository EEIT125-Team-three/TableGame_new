package boardGame.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TableGameOrder {
	@Id
	private String tableGameOrderId;
	@OneToMany
	private List<ShopCar> shopCars;
	private String sentToWho;
	private String sentToAddress;
	private String sentToPhone;
	private Date checkoutDate;
	
	public TableGameOrder() {
		super();
	}

	public TableGameOrder(String tableGameOrderId, String sentToWho, String sentToAddress,
			String sentToPhone, Date checkoutDate) {
		super();
		this.tableGameOrderId = tableGameOrderId;
		this.sentToWho = sentToWho;
		this.sentToAddress = sentToAddress;
		this.sentToPhone = sentToPhone;
		this.checkoutDate = checkoutDate;
	}

	public String getTableGameOrderId() {
		return tableGameOrderId;
	}

	public void setTableGameOrderId(String tableGameOrderId) {
		this.tableGameOrderId = tableGameOrderId;
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
	
}
