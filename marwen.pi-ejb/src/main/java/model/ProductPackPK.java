package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProductPacks database table.
 * 
 */
@Embeddable
public class ProductPackPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ProductId", insertable=false, updatable=false)
	private int productId;

	@Column(name="PackId", insertable=false, updatable=false)
	private int packId;

	public ProductPackPK() {
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPackId() {
		return this.packId;
	}
	public void setPackId(int packId) {
		this.packId = packId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductPackPK)) {
			return false;
		}
		ProductPackPK castOther = (ProductPackPK)other;
		return 
			(this.productId == castOther.productId)
			&& (this.packId == castOther.packId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productId;
		hash = hash * prime + this.packId;
		
		return hash;
	}
}