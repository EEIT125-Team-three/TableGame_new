package boardGame.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ShopCar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shopId;
	@ManyToOne
	private Product pId;
	@ManyToOne
	private MemberBean mId;
	private String sentToWho;
	private String sentToAddress;
	private String sentToPhone;
	private Date checkoutDate;
	private Integer quantity;
	@Column(columnDefinition="nvarchar(MAX)" , nullable = false)
	private String transactionType;
	public ShopCar() {
		super();
	}
	
	public ShopCar(Product pId, MemberBean mId, Integer quantity, String transactionType) {
		super();
		this.pId = pId;
		this.mId = mId;
		this.quantity = quantity;
		this.transactionType = transactionType;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getId() {
		return shopId;
	}

	public void setId(Integer shopId) {
		this.shopId = shopId;
	}

	public Product getpId() {
		return pId;
	}

	public void setpId(Product pId) {
		this.pId = pId;
	}

	public MemberBean getmId() {
		return mId;
	}

	public void setmId(MemberBean mId) {
		this.mId = mId;
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

	public String getSentToWho() {
		return sentToWho;
	}

	public void setSentToWho(String sentToWho) {
		this.sentToWho = sentToWho;
	}
	
}
