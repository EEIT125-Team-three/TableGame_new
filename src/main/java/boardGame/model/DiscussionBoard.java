package boardGame.model;

import java.lang.reflect.Member;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DiscussionBoard")

public class DiscussionBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer discussionBoardID;

	@Column(columnDefinition = "nvarchar(max)")
	private String disArtical;

	@Column(columnDefinition = "nvarchar(max)")
	private String distitle;

	private Date disDate;

	private Integer disLikesNo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "memId")
	private MemberBean member;



	public DiscussionBoard(String disArtical, String distitle, Date disDate, Integer disLikesNo, MemberBean member) {
		super();
		this.disArtical = disArtical;
		this.distitle = distitle;
		this.disDate = disDate;
		this.disLikesNo = disLikesNo;
		this.member = member;
	}

	public Integer DiscussionBoardID() {
		return discussionBoardID;
	}

	public void setDiscussionBoardID(Integer discussionBoardID) {
		this.discussionBoardID = discussionBoardID;
	}

	public String getDisArtical() {
		return disArtical;
	}

	public void setDisArtical(String disArtical) {
		this.disArtical = disArtical;
	}

	public String getDistitle() {
		return distitle;
	}

	public void setDistitle(String distitle) {
		this.distitle = distitle;
	}

	public Date getDisDate() {
		return disDate;
	}

	public void setDisDate(Date disDate) {
		this.disDate = disDate;
	}

	public Integer getDisLikesNo() {
		return disLikesNo;
	}

	public void setDisLikesNo(Integer disLikesNo) {
		this.disLikesNo = disLikesNo;
	}

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

}
