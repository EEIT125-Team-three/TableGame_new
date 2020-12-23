package boardGame.model;

import java.lang.reflect.Member;

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
	private Integer DiscussionBoardID;
	
	@Column(columnDefinition = "nvarchar(max)")
	private String DisArtical;
	
	@Column(columnDefinition = "nvarchar(max)")
	private String Distitle;

	@Column(columnDefinition = "nvarchar(max)")
	private String DisComment;

	private String DisDate;

	private String DisLikesNo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "memId")
	private MemberBean member;

	public DiscussionBoard(Integer discussionBoardID, String disArtical, String distitle, String disComment,
			String disDate, String disLikesNo, MemberBean member) {
		super();
		this.DiscussionBoardID = discussionBoardID;
		this.DisArtical = disArtical;
		this.Distitle = distitle;
		this.DisComment = disComment;
		this.DisDate = disDate;
		this.DisLikesNo = disLikesNo;
		this.member = member;
	}

	public DiscussionBoard() {
		super();
	}

	public Integer getDiscussionBoardID() {
		return DiscussionBoardID;
	}

	public void setDiscussionBoardID(Integer discussionBoardID) {
		this.DiscussionBoardID = discussionBoardID;
	}

	public String getDisComment() {
		return DisComment;
	}

	public void setDisComment(String disComment) {
		this.DisComment = disComment;
	}

	public String getDisDate() {
		return DisDate;
	}

	public void setDisDate(String disDate) {
		this.DisDate = disDate;
	}

	public String getDisLikesNo() {
		return DisLikesNo;
	}

	public void setDisLikesNo(String disLikesNo) {
		this.DisLikesNo = disLikesNo;
	}

	public String getDisArtical() {
		return DisArtical;
	}

	public void setDisArtical(String disArtical) {
		this.DisArtical = disArtical;
	}

	public String getDistitle() {
		return Distitle;
	}

	public void setDistitle(String distitle) {
		this.Distitle = distitle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DiscussionBoard [DiscussionBoardID=");
		builder.append(DiscussionBoardID);
		builder.append(", DisArtical=");
		builder.append(DisArtical);
		builder.append(", Distitle=");
		builder.append(Distitle);
		builder.append(", DisComment=");
		builder.append(DisComment);
		builder.append(", DisDate=");
		builder.append(DisDate);
		builder.append(", DisLikesNo=");
		builder.append(DisLikesNo);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}

}
