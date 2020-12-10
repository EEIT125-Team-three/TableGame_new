package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String E_name;
	@Column(columnDefinition = "nvarchar(255)")
	private String C_name;
	private String img_url;
	private String G_maker;
	private String iss;
	private String info;
	private Integer Price;
	private Integer viewCount;
	private String date;
	private Integer storage;

	public Product() {
	}

	public Product(Integer productId, String e_name, String c_name, String img_url, String g_maker, String iss,
			String info, Integer price, Integer viewCount, String date, Integer storage) {
		super();
		this.productId = productId;
		this.E_name = e_name;
		this.C_name = c_name;
		this.img_url = img_url;
		this.G_maker = g_maker;
		this.iss = iss;
		this.info = info;
		this.Price = price;
		this.viewCount = viewCount;
		this.date = date;
		this.storage = storage;
	}

	public String getE_name() {
		return E_name;
	}

	public void setE_name(String e_name) {
		this.E_name = e_name;
	}

	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		this.C_name = c_name;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getG_maker() {
		return G_maker;
	}

	public void setG_maker(String g_maker) {
		this.G_maker = g_maker;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		this.Price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", E_name=");
		builder.append(E_name);
		builder.append(", C_name=");
		builder.append(C_name);
		builder.append(", img_url=");
		builder.append(img_url);
		builder.append(", G_maker=");
		builder.append(G_maker);
		builder.append(", iss=");
		builder.append(iss);
		builder.append(", info=");
		builder.append(info);
		builder.append(", Price=");
		builder.append(Price);
		builder.append(", viewCount=");
		builder.append(viewCount);
		builder.append(", date=");
		builder.append(date);
		builder.append(", storage=");
		builder.append(storage);
		builder.append("]");
		return builder.toString();
	}

}
