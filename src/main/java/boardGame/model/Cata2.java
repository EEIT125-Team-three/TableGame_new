package boardGame.model;


import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cata2_new")
public class Cata2 {
		@Id
		private Integer keys;
		
		private String cata2;

		@OneToMany(mappedBy = "cata2")
		private Set<DiscussionBoard> BoardIDs;
		
		public Cata2() {
			super();
		}

		public Cata2(Integer keys, String cata2) {
			super();
			this.keys = keys;
			this.cata2 = cata2;
		}

		public Integer getKeys() {
			return keys;
		}

		public void setKeys(Integer keys) {
			this.keys = keys;
		}

		public String getCata2() {
			return cata2;
		}

		public void setCata2(String cata2) {
			this.cata2 = cata2;
		}

		public Set<DiscussionBoard> getBoardIDs() {
			return BoardIDs;
		}
		
		
		
	}
