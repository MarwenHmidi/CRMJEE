package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Clients database table.
 * 
 */
@Entity
@NamedQuery(name="Clients.findAll", query="SELECT c FROM Clients c")
public class Clients implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ClientId")
	private int clientId;

	@Column(name="Address")
	private String address;

	@Column(name="CIN")
	private String cin;

	@Column(name="ClientName")
	private String clientName;

	@Column(name="Type")
	private String type;

	//bi-directional one-to-one association to Users
	@OneToOne
	@JoinColumn(name="ClientId")
	private Users user;

	//bi-directional many-to-one association to Ratings
	@OneToMany(mappedBy="client")
	private List<Ratings> ratings;

	public Clients() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Ratings> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}

	public Ratings addRating(Ratings rating) {
		getRatings().add(rating);
		rating.setClient(this);

		return rating;
	}

	public Ratings removeRating(Ratings rating) {
		getRatings().remove(rating);
		rating.setClient(null);

		return rating;
	}

}