package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ProductPacks database table.
 * 
 */
@Entity
@Table(name="ProductPacks")
@NamedQuery(name="ProductPack.findAll", query="SELECT p FROM ProductPack p")
public class ProductPack implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductPackPK id;
	
	
	@Column(name="EndDate")
	private Date endDate;

	@Column(name="StartDate")
	private Date startDate;

	//bi-directional many-to-one association to Packs
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="PackId",insertable=false, updatable=false)
	private Packs pack;

	//bi-directional many-to-one association to Products
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="ProductId",insertable=false, updatable=false)
	private Products product;

	public ProductPack() {
	}

	public ProductPackPK getId() {
		return this.id;
	}

	public void setId(ProductPackPK id) {
		this.id = id;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Packs getPack() {
		return this.pack;
	}

	public void setPack(Packs pack) {
		this.pack = pack;
	}

	public Products getProduct() {
		return this.product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

}