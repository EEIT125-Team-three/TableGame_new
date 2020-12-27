package boardGame.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cata1_new")
public class Cata1 {
		@Id
		private Integer keys;
		
		private String cata1;

		public Cata1() {
			super();
		}

		public Cata1(Integer keys, String cata1) {
			super();
			this.keys = keys;
			this.cata1 = cata1;
		}

		public Integer getKeys() {
			return keys;
		}

		public void setKeys(Integer keys) {
			this.keys = keys;
		}

		public String getCata1() {
			return cata1;
		}

		public void setCata1(String cata1) {
			this.cata1 = cata1;
		}
		
		
		
	}
