package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class shopCarProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String userId;
	private String pEName;
	private Integer quantity;
	private String transactionType;
	public shopCarProduct() {
		super();
	}
	public shopCarProduct(String userId, String pEName, Integer quantity, String transactionType) {
		super();
		this.userId = userId;
		this.pEName = pEName;
		this.quantity = quantity;
		this.transactionType = transactionType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getpEName() {
		return pEName;
	}
	public void setpEName(String pEName) {
		this.pEName = pEName;
	}
	public void setProduct(String product) {
		this.pEName = product;
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
	
}
