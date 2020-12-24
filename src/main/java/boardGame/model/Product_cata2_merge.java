package boardGame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product_cata2_merge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer num;
	@Column(name="productId")
	private Integer productId;
	private Integer Keys;
	
	public Product_cata2_merge() {
		super();
	}
	public Product_cata2_merge(Integer productId, Integer keys) {
		super();
		this.productId = productId;
		Keys = keys;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getKeys() {
		return Keys;
	}
	public void setKeys(Integer keys) {
		Keys = keys;
	}
	
	
}
