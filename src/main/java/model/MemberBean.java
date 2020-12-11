package model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="MemberList")
public class MemberBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memId;
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL") 
	private String memAccount;
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL") 
	private String memPassword;
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL") 
	private String memName;
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL") 
	private String memGender;
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL") 
	private String memBirthday;
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL")
	private String memPhone;
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL") 
	private String memMailaddress;
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL") 
	private String memAddress;
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL") 
	private String memIdNumber;
	@Column(columnDefinition = "int NOT NULL")
	private Integer memRefund;
	@Column(columnDefinition = "nvarchar(MAX) NOT NULL") 
	private String memPic;
	
	@OneToMany(mappedBy = "member")
	Set<DiscussionBoard> discussionBoard = new HashSet<>();
	
	@OneToMany(mappedBy = "member")
	Set<MPmerge> MPmerge  = new HashSet<>();
	
	@OneToMany(mappedBy = "member")
	Set<MImerge> sign  = new HashSet<>();
	
	@OneToMany(mappedBy = "mId", fetch = FetchType.EAGER)
	Set<ShopCar> shopcar = new HashSet<>();
	
	@OneToMany(mappedBy = "mId", fetch = FetchType.EAGER)
	Set<List> list = new HashSet<>();
		
	public MemberBean() {
		super();
	}



	public MemberBean(Integer memId, String memAccount, String memPassword, String memName, String memGender,
			String memBirthday, String memPhone, String memMailaddress, String memAddress, String memIdNumber,
			Integer memRefund, String memPic) {
		super();
		this.memId = memId;
		this.memAccount = memAccount;
		this.memPassword = memPassword;
		this.memName = memName;
		this.memGender = memGender;
		this.memBirthday = memBirthday;
		this.memPhone = memPhone;
		this.memMailaddress = memMailaddress;
		this.memAddress = memAddress;
		this.memIdNumber = memIdNumber;
		this.memRefund = memRefund;
		this.memPic = memPic;
	}



	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getMemAccount() {
		return memAccount;
	}

	public void setMemAccount(String memAccount) {
		this.memAccount = memAccount;
	}

	public String getMemPassword() {
		return memPassword;
	}

	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemGender() {
		return memGender;
	}

	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}

	public String getMemBirthday() {
		return memBirthday;
	}

	public void setMemBirthday(String memBirthday) {
		this.memBirthday = memBirthday;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemMailaddress() {
		return memMailaddress;
	}

	public void setMemMailaddress(String memMailaddress) {
		this.memMailaddress = memMailaddress;
	}

	public String getMemAddress() {
		return memAddress;
	}

	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}

	public String getMemIdNumber() {
		return memIdNumber;
	}

	public void setMemIdNumber(String memIdNumber) {
		this.memIdNumber = memIdNumber;
	}

	public Integer getMemRefund() {
		return memRefund;
	}

	public void setMemRefund(Integer memRefund) {
		this.memRefund = memRefund;
	}

	public String getMemPic() {
		return memPic;
	}

	public void setMemPic(String memPic) {
		this.memPic = memPic;
	}

	public Set<DiscussionBoard> getDiscussionBoard() {
		return discussionBoard;
	}

	public void setDiscussionBoard(Set<DiscussionBoard> discussionBoard) {
		this.discussionBoard = discussionBoard;
	}

	public Set<MPmerge> getMPmerge() {
		return MPmerge;
	}

	public void setMPmerge(Set<MPmerge> mPmerge) {
		this.MPmerge = mPmerge;
	}

	public Set<MImerge> getSign() {
		return sign;
	}

	public void setSign(Set<MImerge> sign) {
		this.sign = sign;
	}

	public Set<ShopCar> getShopcar() {
		return shopcar;
	}

	public void setShopcar(Set<ShopCar> shopcar) {
		this.shopcar = shopcar;
	}

	public Set<List> getList() {
		return list;
	}

	public void setList(Set<List> list) {
		this.list = list;
	}


	
}
