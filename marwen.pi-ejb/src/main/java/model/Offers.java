package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Offers database table.
 * 
 */
@Entity
@NamedQuery(name="Offers.findAll", query="SELECT o FROM Offers o")
public class Offers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OfferId")
	private int offerId;

	@Column(name="Description")
	private String description;

	@Column(name="EndDate")
	private Date endDate;

	@Column(name="ImgUrl")
	private String imgUrl;

	@Column(name="OfferName")
	private String offerName;

	@Column(name="Price")
	private float price;

	@Column(name="ProductId")
	private int productId;

	@Column(name="StartDate")
	private Date startDate;

	//bi-directional one-to-one association to Products
	@OneToOne(mappedBy="offer")
	private Products product;

	//bi-directional many-to-one association to Ratings
	@OneToMany(mappedBy="offer")
	private List<Ratings> ratings;

	public Offers() {
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

	public String getOfferName() {
		return this.offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
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

	public Products getProduct() {
		return this.product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public List<Ratings> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}

	public Ratings addRating(Ratings rating) {
		getRatings().add(rating);
		rating.setOffer(this);

		return rating;
	}

	public Ratings removeRating(Ratings rating) {
		getRatings().remove(rating);
		rating.setOffer(null);

		return rating;
	}

}