package model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
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

import org.springframework.web.bind.annotation.Mapping;

@Entity
@Table(name = "InfoTable")
public class InfoBean implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer activityId;
	@Column(columnDefinition = "VARCHAR(32) NOT NULL")
	String actArea;
	@Column(columnDefinition = "VARCHAR(32) NOT NULL")
	String actType;
	@Column(columnDefinition = "VARCHAR(32) NOT NULL")
	String activity;
	@Column(columnDefinition = "Date NOT NULL")
	Date actDate1;
	@Column(columnDefinition = "Time NOT NULL")
	Time actStrTime1;
	@Column(columnDefinition = "Time NOT NULL")
	Time actEndTime1;
	@Column(columnDefinition = "Date NOT NULL")
	Date actDate2;
	@Column(columnDefinition = "Time NOT NULL")
	Time actStrTime2;
	@Column(columnDefinition = "Time NOT NULL")
	Time actEndTime2;
	@Column(columnDefinition = "Integer NOT NULL")
	Integer actDay;
	@Column(columnDefinition = "VARCHAR(32) NOT NULL")
	String actLocation;
	@Column(columnDefinition = "VARCHAR(32) NOT NULL")
	String actAddress;
	@Column(columnDefinition = "Integer")
	Integer actLimitPer;
	@Column(columnDefinition = "Integer")
	Integer actCost;

	@OneToMany(mappedBy = "memId", fetch = FetchType.EAGER)
	Set<MemberBean> member = new HashSet<>();


	public InfoBean() {
		super();
	}

	public InfoBean(Integer activityId, String actArea, String actType, String activity, Date actDate1,
			Time actStrTime1, Time actEndTime1, Date actDate2, Time actStrTime2, Time actEndTime2, Integer actDay,
			String actLocation, String actAddress, Integer actLimitPer, Integer actCost) {

		super();
		this.activityId = activityId;
		this.actArea = actArea;
		this.actType = actType;
		this.activity = activity;
		this.actDate1 = actDate1;
		this.actStrTime1 = actStrTime1;
		this.actEndTime1 = actEndTime1;
		this.actDate2 = actDate2;
		this.actStrTime2 = actStrTime2;
		this.actEndTime2 = actEndTime2;
		this.actDay = actDay;
		this.actLocation = actLocation;
		this.actAddress = actAddress;
		this.actLimitPer = actLimitPer;
		this.actCost = actCost;

	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActArea() {
		return actArea;
	}

	public void setActArea(String actArea) {
		this.actArea = actArea;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Date getActDate1() {
		return actDate1;
	}

	public void setActDate1(Date actDate1) {
		this.actDate1 = actDate1;
	}

	public Time getActStrTime1() {
		return actStrTime1;
	}

	public void setActStrTime1(Time actStrTime1) {
		this.actStrTime1 = actStrTime1;
	}

	public Time getActEndTime1() {
		return actEndTime1;
	}

	public void setActEndTime1(Time actEndTime1) {
		this.actEndTime1 = actEndTime1;
	}

	public Date getActDate2() {
		return actDate2;
	}

	public void setActDate2(Date actDate2) {
		this.actDate2 = actDate2;
	}

	public Time getActStrTime2() {
		return actStrTime2;
	}

	public void setActStrTime2(Time actStrTime2) {
		this.actStrTime2 = actStrTime2;
	}

	public Time getActEndTime2() {
		return actEndTime2;
	}

	public void setActEndTime2(Time actEndTime2) {
		this.actEndTime2 = actEndTime2;
	}

	public Integer getActDay() {
		return actDay;
	}

	public void setActDay(Integer actDay) {
		this.actDay = actDay;
	}

	public String getActLocation() {
		return actLocation;
	}

	public void setActLocation(String actLocation) {
		this.actLocation = actLocation;
	}

	public String getActAddress() {
		return actAddress;
	}

	public void setActAddress(String actAddress) {
		this.actAddress = actAddress;
	}

	public Integer getActLimitPer() {
		return actLimitPer;
	}

	public void setActLimitPer(Integer actLimitPer) {
		this.actLimitPer = actLimitPer;
	}

	public Integer getActCost() {
		return actCost;
	}

	public void setActCost(Integer actCost) {
		this.actCost = actCost;
	}

	public Set<MemberBean> getMember() {
		return member;
	}

	public void setMember(Set<MemberBean> member) {
		this.member = member;
	}

}
