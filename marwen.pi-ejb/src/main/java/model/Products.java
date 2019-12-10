package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Products database table.
 * 
 */
@Entity
@NamedQuery(name="Products.findAll", query="SELECT p FROM Products p")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductId")
	private int productId;

	@Column(name="ImageUrl")
	private String imageUrl;

	@Column(name="Price")
	private float price;

	@Column(name="Quantity")
	private long quantity;

	@Column(name="Title")
	private String title;

	@Column(name="Type")
	private String type;

	//bi-directional many-to-one association to ProductPack
	@OneToMany(mappedBy="product")
	private List<ProductPack> productPacks;

	//bi-directional one-to-one association to Offers
	@OneToOne
	@JoinColumn(name="ProductId")
	private Offers offer;

	public Products() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ProductPack> getProductPacks() {
		return this.productPacks;
	}

	public void setProductPacks(List<ProductPack> productPacks) {
		this.productPacks = productPacks;
	}

	public ProductPack addProductPack(ProductPack productPack) {
		getProductPacks().add(productPack);
		productPack.setProduct(this);

		return productPack;
	}

	public ProductPack removeProductPack(ProductPack productPack) {
		getProductPacks().remove(productPack);
		productPack.setProduct(null);

		return productPack;
	}

	public Offers getOffer() {
		return this.offer;
	}

	public void setOffer(Offers offer) {
		this.offer = offer;
	}



}