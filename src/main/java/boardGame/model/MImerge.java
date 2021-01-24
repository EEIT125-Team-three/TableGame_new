package boardGame.model;

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
@Table(name="Sign")
public class MImerge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer miId;
	private String payedCheck;
	


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memId")
	MemberBean member;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="activityId")
	InfoBean info;
	
	public MImerge(MemberBean member, InfoBean info, String payedCheck) {
		super();

		this.member = member;
		this.info = info;
		this.payedCheck = payedCheck;
	}

	public MImerge() {
		super();
	}

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public InfoBean getInfo() {
		return info;
	}

	public void setInfo(InfoBean info) {
		this.info = info;
	}

	public Integer getMiId() {
		return miId;
	}

	public void setMiId(Integer miId) {
		this.miId = miId;
	}

	public String getPayedCheck() {
		return payedCheck;
	}
	
	public void setPayedCheck(String payedCheck) {
		this.payedCheck = payedCheck;
	}
	
	
}
