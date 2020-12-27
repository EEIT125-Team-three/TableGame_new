package boardGame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product_cata1_merge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer num;

	@ManyToOne
	private Product productId;

	@ManyToOne
	private Cata1 keys;
	

	public Product_cata1_merge(Integer num, Product productId, Cata1 keys) {
		super();
		this.num = num;
		this.productId = productId;
		this.keys = keys;
	}

	public Product_cata1_merge() {
		super();
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Cata1 getKeys() {
		return keys;
	}

	public void setKeys(Cata1 keys) {
		this.keys = keys;
	}
	
	
}
