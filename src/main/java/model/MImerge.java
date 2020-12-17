package model;

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
	
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL")
	private String sign;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memId")
	MemberBean member;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="activityId")
	InfoBean info;
	
	public MImerge(String sign, MemberBean member, InfoBean info) {
		super();
		this.sign = sign;
		this.member = member;
		this.info = info;
	}

	public MImerge() {
		super();
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	
	
}
