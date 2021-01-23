package boardGame.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.crypto.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MemberRequestHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer requestHistoryId;
	
	@ManyToOne
	@JsonIgnore
	private MemberBean whoTalk;
	
	private String requestContent;
	
	@ManyToOne
	@JsonIgnore
	private MemberBean memberBean;
	
	private Date thisMessageTime;

	public MemberRequestHistory() {
		super();
	}
	
	public MemberRequestHistory(String requestContent, MemberBean memberBean, Date thisMessageTime, MemberBean whoTalk) {
		super();
		this.requestContent = requestContent;
		this.memberBean = memberBean;
		this.thisMessageTime = thisMessageTime;
		this.whoTalk = whoTalk;
	}

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public Integer getRequestHistoryId() {
		return requestHistoryId;
	}

	public Date getThisMessageTime() {
		return thisMessageTime;
	}

	public void setThisMessageTime(Date thisMessageTime) {
		this.thisMessageTime = thisMessageTime;
	}

	public MemberBean getWhoTalk() {
		return whoTalk;
	}
	
}
