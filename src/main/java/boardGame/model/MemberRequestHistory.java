package boardGame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MemberRequestHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer requestHistoryId;
	
	private String requestContent;
	
	@ManyToOne
	@JsonIgnore
	private MemberBean memberBean;

	public MemberRequestHistory() {
		super();
	}
	
	public MemberRequestHistory(String requestContent, MemberBean memberBean) {
		super();
		this.requestContent = requestContent;
		this.memberBean = memberBean;
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
	
}
