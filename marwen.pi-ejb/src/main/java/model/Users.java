package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@NamedQuery(name="Users.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId")
	private int userId;

	@Column(name="AgentId")
	private int agentId;

	@Column(name="ClientId")
	private int clientId;

	@Column(name="ProspectId")
	private int prospectId;

	@Column(name="UserName")
	private String userName;

	@Column(name="UserType")
	private String userType;

	//bi-directional one-to-one association to Agents
	@OneToOne(mappedBy="user")
	private Agents agent;

	//bi-directional one-to-one association to Clients
	@OneToOne(mappedBy="user")
	private Clients client;

	//bi-directional one-to-one association to Prospects
	@OneToOne(mappedBy="user")
	private Prospects prospect;

	public Users() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAgentId() {
		return this.agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getProspectId() {
		return this.prospectId;
	}

	public void setProspectId(int prospectId) {
		this.prospectId = prospectId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Agents getAgent() {
		return this.agent;
	}

	public void setAgent(Agents agent) {
		this.agent = agent;
	}

	public Clients getClient() {
		return this.client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public Prospects getProspect() {
		return this.prospect;
	}

	public void setProspect(Prospects prospect) {
		this.prospect = prospect;
	}

}