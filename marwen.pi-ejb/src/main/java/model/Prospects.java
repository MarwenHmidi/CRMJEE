package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Prospects database table.
 * 
 */
@Entity
@NamedQuery(name="Prospects.findAll", query="SELECT p FROM Prospects p")
public class Prospects implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProspectId")
	private int prospectId;

	@Column(name="Address")
	private String address;

	@Column(name="ProspectName")
	private String prospectName;

	//bi-directional one-to-one association to Users
	@OneToOne
	@JoinColumn(name="ProspectId")
	private Users user;

	public Prospects() {
	}

	public int getProspectId() {
		return this.prospectId;
	}

	public void setProspectId(int prospectId) {
		this.prospectId = prospectId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProspectName() {
		return this.prospectName;
	}

	public void setProspectName(String prospectName) {
		this.prospectName = prospectName;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}