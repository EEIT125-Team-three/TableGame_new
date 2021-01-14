package boardGame.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DiscountCode")
public class DiscountCode {
		@Id
		private Integer num;
		
		private String discountCode;

		
		public DiscountCode() {
			super();
		}

		public DiscountCode(Integer num, String discountCode) {
			super();
			this.num = num;
			this.discountCode = discountCode;
		}

		public Integer getNum() {
			return num;
		}

		public void setNum(Integer num) {
			this.num = num;
		}

		public String getDiscountCode() {
			return discountCode;
		}

		public void setDiscountCode(String discountCode) {
			this.discountCode = discountCode;
		}

	}
