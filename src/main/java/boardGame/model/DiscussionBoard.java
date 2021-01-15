package boardGame.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DiscussionBoard")

public class DiscussionBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer discussionBoardID;

	@ManyToOne
	@JoinColumn(name = "memId")
	private MemberBean member;

	@Column(columnDefinition = "nvarchar(max)")
	private String distitle;

	@Column(columnDefinition = "nvarchar(max)")
	private String disArtical;

	@Column(columnDefinition = "smalldatetime")
	private Date disDate;

	private Integer sectionNum;
	
	@ManyToOne
	private Cata2 cata2;
	
	private Integer disLikesNo;

	public DiscussionBoard(MemberBean member, String distitle, String disArtical,
			Date disDate, Integer sectionNum, Cata2 cata2, Integer disLikesNo) {
		super();
		this.member = member;
		this.distitle = distitle;
		this.disArtical = disArtical;
		this.disDate = disDate;
		this.sectionNum = sectionNum;
		this.cata2 = cata2;
		this.disLikesNo = disLikesNo;
	}

	public DiscussionBoard() {
		super();
	}

	public Integer getDiscussionBoardID() {
		return discussionBoardID;
	}

	public void setDiscussionBoardID(Integer discussionBoardID) {
		this.discussionBoardID = discussionBoardID;
	}

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public String getDistitle() {
		return distitle;
	}

	public void setDistitle(String distitle) {
		this.distitle = distitle;
	}

	public String getDisArtical() {
		return disArtical;
	}

	public void setDisArtical(String disArtical) {
		this.disArtical = disArtical;
	}

	public Date getDisDate() {
		return disDate;
	}

	public void setDisDate(Date disDate) {
		this.disDate = disDate;
	}

	public Integer getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(Integer sectionNum) {
		this.sectionNum = sectionNum;
	}

	public Cata2 getCata2() {
		return cata2;
	}

	public void setCata2(Cata2 cata2) {
		this.cata2 = cata2;
	}

	public Integer getDisLikesNo() {
		return disLikesNo;
	}

	public void setDisLikesNo(Integer disLikesNo) {
		this.disLikesNo = disLikesNo;
	}	

}
