package boardGame.model;



import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ReText")
public class ReText implements Serializable{
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer num;
		@Column(columnDefinition ="Integer", nullable = false)
		private Integer memId;
		@Column(columnDefinition ="Integer", nullable = false)
		private Integer mainArticleId;
		@Column(columnDefinition ="nvarchar(MAX)", nullable = false)
		private String reTextTitle;
		@Column(columnDefinition ="nvarchar(MAX)", nullable = false)
		private String reText;
		@Column(columnDefinition ="nvarchar(MAX)", nullable = false)
		private String memNam;
		@Column(columnDefinition = "smalldatetime")
		private Date date;
		
		public ReText() {
		}
		public ReText(Integer num,Integer memId, Integer mainArticleId, String reTextTitle, String reText,String memName,
				Date date) {
			super();
			this.num = num;
			this.memId = memId;
			this.mainArticleId = mainArticleId;
			this.reTextTitle = reTextTitle;
			this.reText = reText;
			this.memNam = memName;
			this.date = date;
		}
		public Integer getNum() {
			return num;
		}
		public void setNum(Integer num) {
			this.num = num;
		}
		public Integer getMemId() {
			return memId;
		}
		public void setMemId(Integer memId) {
			this.memId = memId;
		}
		public Integer getMainArticleId() {
			return mainArticleId;
		}
		public void setMainArticleId(Integer mainArticleId) {
			this.mainArticleId = mainArticleId;
		}
		public String getReTextTitle() {
			return reTextTitle;
		}
		public void setReTextTitle(String reTextTitle) {
			this.reTextTitle = reTextTitle;
		}
		public String getReText() {
			return reText;
		}
		public void setReText(String reText) {
			this.reText = reText;
		}
		public String getMemNam() {
			return memNam;
		}
		public void setMemNam(String memNam) {
			this.memNam = memNam;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		
	}
