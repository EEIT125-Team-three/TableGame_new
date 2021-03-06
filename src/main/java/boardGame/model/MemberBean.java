package boardGame.model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MemberList")
public class MemberBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memId;
	private String memAccount;
	private String memPassword;
	private String memName;
	private String memGender;
	private String memBirthday;
	private String memPhone;
	private String memMailaddress;
	private String memAddress;
	private String memIdNumber;
	private Integer memRefund;
	private String memPic;
	private String checkId;
	private boolean memCheckAu;
	private boolean discountCheck;
	private Timestamp resisterTime;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	Set<DiscussionBoard> discussionBoard = new HashSet<>();
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	Set<MPmerge> MPmerge  = new HashSet<>();
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	Set<MImerge> sign  = new HashSet<>();
	
	@OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
	Set<TableGameOrder> tableGameOrders = new HashSet<>();
	
	@OneToMany(mappedBy = "mId", cascade = CascadeType.ALL)
	Set<TrackList> list = new HashSet<>();
	
	@OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
	Set<SessionBean> sessionBeans = new HashSet<>();
	
	@OneToMany(mappedBy = "memberBean", cascade = CascadeType.ALL)
	List<MemberRequestHistory> memberRequestHistory = new ArrayList<MemberRequestHistory>();
	
	@ManyToOne
	private Road road;
	
	public MemberBean() {
		super();
	}

	public MemberBean(Integer memId, String memAccount, String memPassword, String memName, String memGender,
			String memBirthday, String memPhone, String memMailaddress, String memAddress, String memIdNumber,
			Integer memRefund, String memPic,boolean discountCheck) {
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
		this.discountCheck = discountCheck;
		if(memRefund == null) {
			this.memRefund = 0;
		}else {
			this.memRefund = memRefund;	
		}
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
			

	public boolean isMemCheckAu() {
		return memCheckAu;
	}

	public void setMemCheckAu(boolean memCheckAu) {
		this.memCheckAu = memCheckAu;
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

	public Set<TrackList> getList() {
		return list;
	}

	public void setList(Set<TrackList> list) {
		this.list = list;
	}

	public Set<TableGameOrder> getTableGameOrders() {
		return tableGameOrders;
	}

	public void setTableGameOrders(Set<TableGameOrder> tableGameOrders) {
		this.tableGameOrders = tableGameOrders;
	}

	public Set<SessionBean> getSessionBeans() {
		return sessionBeans;
	}

	public void setSessionBeans(Set<SessionBean> sessionBeans) {
		this.sessionBeans = sessionBeans;
	}

	public Road getRoad() {
		return road;
	}

	public void setRoad(Road road) {
		this.road = road;
	}
	public boolean isDiscountCheck() {
		return discountCheck;
	}

	public void setDiscountCheck(boolean discountCheck) {
		this.discountCheck = discountCheck;
	}

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public Timestamp getResisterTime() {
		return resisterTime;
	}

	public void setResisterTime(Timestamp resisterTime) {
		this.resisterTime = resisterTime;
	}

	public List<MemberRequestHistory> getMemberRequestHistory() {
		return memberRequestHistory;
	}
	
}
