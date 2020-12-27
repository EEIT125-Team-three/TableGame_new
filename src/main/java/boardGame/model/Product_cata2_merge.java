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
public class Product_cata2_merge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer num;
//	@Column(name="productId")
	@ManyToOne
	private Product productId;
//	@Column(name="keys")
	@ManyToOne
	private Cata2 keys;
	
	public Product_cata2_merge() {
		super();
	}

	public Product_cata2_merge(Integer num, Product productId, Cata2 keys) {
		super();
		this.num = num;
		this.productId = productId;
		this.keys = keys;
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

	public Cata2 getKeys() {
		return keys;
	}

	public void setKeys(Cata2 keys) {
		this.keys = keys;
	}

	
	
}
