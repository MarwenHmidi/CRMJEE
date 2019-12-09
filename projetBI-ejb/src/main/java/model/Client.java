package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Clients database table.
 * 
 */
@Entity
@Table(name="Clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdClient")
	private int idClient;

	@Column(name="BirthDate")
	private Date birthDate;

	@Column(name="ClientType")
	private int clientType;

	@Column(name="Email")
	private String email;

	@Column(name="LastName")
	private String lastName;

	@Column(name="Name")
	private String name;

	@Column(name="Password")
	private String password;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	private int pointmerci;

	public Client() {
	}
	

	public Client(int idClient, Date birthDate, int clientType, String email, String lastName, String name,
			String password, String phoneNumber, int pointmerci) {
		super();
		this.idClient = idClient;
		this.birthDate = birthDate;
		this.clientType = clientType;
		this.email = email;
		this.lastName = lastName;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.pointmerci = pointmerci;
	}


	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getClientType() {
		return this.clientType;
	}

	public void setClientType(int clientType) {
		this.clientType = clientType;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPointmerci() {
		return this.pointmerci;
	}

	public void setPointmerci(int pointmerci) {
		this.pointmerci = pointmerci;
	}


	@Override
	public String toString() {
		return "Client [birthDate=" + birthDate + ", clientType=" + clientType + ", email=" + email + ", lastName="
				+ lastName + ", name=" + name + ", pointmerci=" + pointmerci + "]";
	}
	

}