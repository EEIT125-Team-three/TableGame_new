package boardGame.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SessionBean {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer session;
	
	private String sessionId;
	@ManyToOne
	private MemberBean memberId;

	public MemberBean getMemberId() {
		return memberId;
	}

	public SessionBean() {
		super();
	}
	
	public SessionBean(String sessionId, MemberBean memberId) {
		super();
		this.sessionId = sessionId;
		this.memberId = memberId;
	}
	
	
	
	
	
	
}
