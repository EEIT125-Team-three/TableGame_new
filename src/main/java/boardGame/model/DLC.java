package boardGame.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DLC")
public class DLC {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer num;
		
		@ManyToOne
		private Product productId;

		@ManyToOne
		private Product DLCId;


		public DLC(Integer num, Product productId, Product dLCId) {
			super();
			this.num = num;
			this.productId = productId;
			DLCId = dLCId;
		}

		public DLC() {
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

		public Product getDLCId() {
			return DLCId;
		}

		public void setDLCId(Product dLCId) {
			DLCId = dLCId;
		}
		
		
		
		

		
		
		
		
	}
