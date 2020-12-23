package boardGame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DiscussionBoard_new")
public class dis {
		// @GeneratedValue(strategy = GenerationType.IDENTITY)
//		@Column(name = "mem_id", columnDefinition = "nvarchar(MAX)")
		@Id
		private String id;

		@Column(name = "Dis_name", columnDefinition = "nvarchar(50)")
		private String name;

		@Column(name = "Dis_comment", columnDefinition = "nvarchar(50)")
		private String comment;

//		@Column(name="Dis_date", columnDefinition = "datetime" )
		private String date;

//		@Column(name="mem_pic", columnDefinition = "image" )
		private String pic;

		public dis(String id, String name, String comment, String date) {
			super();
			this.id = id;
			this.name = name;
			this.comment = comment;
			this.date = date;
			// this.pic = pic;
		}

		public dis() {
			super();
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getPic() {
			return pic;
		}

		public void setPic(String pic) {
			this.pic = pic;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("SetDis [id=");
			builder.append(id);
			builder.append(", name=");
			builder.append(name);
			builder.append(", comment=");
			builder.append(comment);
			builder.append(", date=");
			builder.append(date);
			builder.append(", pic=");
			builder.append(pic);
			builder.append("]");
			return builder.toString();
		}
	}
