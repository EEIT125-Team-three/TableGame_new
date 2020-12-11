package model;

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
	
	private Integer quantity;
	private String transactionType;
	public ShopCar() {
		super();
	}
	
	public ShopCar(Integer shopId, Product pId, MemberBean mId, Integer quantity, String transactionType) {
		super();
		this.shopId = shopId;
		this.pId = pId;
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
	
}
