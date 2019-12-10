package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Packs database table.
 * 
 */
@Entity
@NamedQuery(name="Packs.findAll", query="SELECT p FROM Packs p")
public class Packs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PackId")
	private int packId;

	@Column(name="Description")
	private String description;

	@Column(name="EndDate")
	private Date endDate;

	@Column(name="ImgUrl")
	private String imgUrl;

	@Column(name="PackName")
	private String packName;

	@Column(name="Quantity")
	private int quantity;

	@Column(name="StartDate")
	private Date startDate;

	@Column(name="TypePack")
	private String typePack;

	public Packs() {
	}

	
	public Packs( String description, Date endDate, String imgUrl, String packName, int quantity,
			Date startDate, String typePack ) {
		super();
		this.description = description;
		this.endDate = endDate;
		this.imgUrl = imgUrl;
		this.packName = packName;
		this.quantity = quantity;
		this.startDate = startDate;
		this.typePack = typePack;
	}
	
	public Packs(String description, Date endDate, String imgUrl, String packName, int quantity,
			Date startDate, String typePack,int id ) {
		super();
		this.description = description;
		this.endDate = endDate;
		this.imgUrl = imgUrl;
		this.packName = packName;
		this.quantity = quantity;
		this.startDate = startDate;
		this.typePack = typePack;
		this.packId=id;
	}

	public int getPackId() {
		return this.packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
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

	public String getPackName() {
		return this.packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTypePack() {
		return this.typePack;
	}

	public void setTypePack(String typePack) {
		this.typePack = typePack;
	}

}