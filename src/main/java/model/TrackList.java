package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TrackList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer likeId;
	@ManyToOne
	private Product pId;
	@ManyToOne
	private MemberBean mId;
	public TrackList() {
		super();
	}
	public TrackList(Integer likeId, Product pId, MemberBean mId) {
		super();
		this.likeId = likeId;
		this.pId = pId;
		this.mId = mId;
	}
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}
	public Product getpId() {
		return pId;
	}
	public void setpId(Product pId) {
		this.pId = pId;
	}
	public MemberBean getmId() {
		return mId;
	}
	public void setmId(MemberBean mId) {
		this.mId = mId;
	}
	
}
