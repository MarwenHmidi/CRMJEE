package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Ratings database table.
 * 
 */
@Embeddable
public class RatingsPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ClientId", insertable=false, updatable=false)
	private int clientId;

	@Column(name="OfferId", insertable=false, updatable=false)
	private int offerId;

	public RatingsPK() {
	}
	public int getClientId() {
		return this.clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getOfferId() {
		return this.offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RatingsPK)) {
			return false;
		}
		RatingsPK castOther = (RatingsPK)other;
		return 
			(this.clientId == castOther.clientId)
			&& (this.offerId == castOther.offerId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.clientId;
		hash = hash * prime + this.offerId;
		
		return hash;
	}
}