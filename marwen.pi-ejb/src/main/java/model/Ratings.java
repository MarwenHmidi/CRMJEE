package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Ratings database table.
 * 
 */
@Entity
@NamedQuery(name="Ratings.findAll", query="SELECT r FROM Ratings r")
public class Ratings implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RatingsPK id;

	@Column(name="RatingsValue")
	private int ratingsValue;

	//bi-directional many-to-one association to Clients
	@ManyToOne
	@JoinColumn(name="ClientId",insertable=false, updatable=false)
	private Clients client;

	//bi-directional many-to-one association to Offers
	@ManyToOne
	@JoinColumn(name="OfferId",insertable=false, updatable=false)
	private Offers offer;

	public Ratings() {
	}

	public RatingsPK getId() {
		return this.id;
	}

	public void setId(RatingsPK id) {
		this.id = id;
	}

	public int getRatingsValue() {
		return this.ratingsValue;
	}

	public void setRatingsValue(int ratingsValue) {
		this.ratingsValue = ratingsValue;
	}

	public Clients getClient() {
		return this.client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public Offers getOffer() {
		return this.offer;
	}

	public void setOffer(Offers offer) {
		this.offer = offer;
	}

}