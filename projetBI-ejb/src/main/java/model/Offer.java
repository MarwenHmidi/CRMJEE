package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the Offers database table.
 * 
 */
@Entity
@Table(name="Offers")
@NamedQuery(name="Offer.findAll", query="SELECT o FROM Offer o")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OfferId")
	private int offerId;

	@Column(name="Description")
	private String  description;

	@Column(name="EndDate")
	private Date endDate;

	@Column(name="ImgUrl")
	private String imgUrl;

	@Column(name="ProductId")
	private int productId;

	@Column(name="StartDate")
	private Date startDate;

	public Offer() {
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}