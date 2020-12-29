package boardGame.model;

import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "memId")
	private MemberBean member;

	@Column(columnDefinition = "nvarchar(max)")
	private String distitle;

	@Column(columnDefinition = "nvarchar(max)")
	private String disArtical;

	@Column(columnDefinition = "smalldatetime")
	private Date disDate;

	private Integer disLikesNo;

	public DiscussionBoard(MemberBean member,String distitle, String disArtical, Date disDate, Integer disLikesNo) {
		super();
		this.member = member;
		this.distitle = distitle;
		this.disArtical = disArtical;
		this.disDate = disDate;
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
