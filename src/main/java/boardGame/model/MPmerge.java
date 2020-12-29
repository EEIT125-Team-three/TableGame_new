package boardGame.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="MPmerge")
public class MPmerge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mpId;
	
	@ManyToOne
	@JoinColumn(name="memId")
	MemberBean member;
	@ManyToOne
	@JoinColumn(name="productId")
	Product product;
	
	private Integer viewCount;
	

	public MPmerge(MemberBean member, Product product, Integer viewCount) {
		super();

		this.member = member;
		this.product = product;
		this.viewCount = viewCount;
	}

	public MPmerge() {
		super();
	}

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	
	
	
}
